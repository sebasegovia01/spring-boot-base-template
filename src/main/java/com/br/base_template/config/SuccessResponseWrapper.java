package com.br.base_template.config;

import com.br.base_template.common.RespStatus;
import com.br.base_template.dto.SuccessResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
public class SuccessResponseWrapper implements ResponseBodyAdvice<Object> {

    private final HttpServletRequest request;
    private final String localTransactionId;

    public SuccessResponseWrapper(HttpServletRequest request, @Value("${header.local.transaction-id}") String localTransactionId) {
        this.request = request;
        this.localTransactionId = localTransactionId;
    }

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  org.springframework.http.server.ServerHttpRequest serverRequest,
                                  org.springframework.http.server.ServerHttpResponse serverResponse) {
        if (body instanceof SuccessResponseDto || body instanceof ResponseEntity) {
            return body;
        }

        // Extract Trace-Req-Timestamp from the request headers
        String traceReqTimestamp = request.getHeader("Trace-Req-Timestamp");
        if (traceReqTimestamp == null || traceReqTimestamp.isEmpty()) {
            traceReqTimestamp = ResponseHeader.getCurrentTimestamp();
        }

        // Create ResponseHeader and set the required fields
        ResponseHeader responseHeader = new ResponseHeader(
                traceReqTimestamp,
                ResponseHeader.getCurrentTimestamp(),
                request.getHeader("Trace-Source-Id"),
                localTransactionId
        );

        // Set the headers in the response
        serverResponse.getHeaders().add("Trace-Req-Timestamp", responseHeader.getTraceReqTimestamp());
        serverResponse.getHeaders().add("Trace-Rsp-Timestamp", responseHeader.getTraceRspTimestamp());
        serverResponse.getHeaders().add("Trace-Source-Id", responseHeader.getTraceSourceId());
        serverResponse.getHeaders().add("Local-Transaction-Id", responseHeader.getLocalTransactionId());

        // Wrap the body in SuccessResponseDto
        SuccessResponseDto<Object> successResponse = new SuccessResponseDto<>();
        successResponse.setStatus(RespStatus.OK);
        successResponse.setResult(body);
        successResponse.setDescription("Request was successful");

        return successResponse;
    }
}
