package com.br.base_template.config;

import com.br.base_template.common.RespStatus;
import com.br.base_template.dto.SuccessResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SuccessResponseWrapper implements ResponseBodyAdvice<Object> {

    private final HttpServletRequest request;

    public SuccessResponseWrapper(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  org.springframework.http.server.ServerHttpRequest request,
                                  org.springframework.http.server.ServerHttpResponse response) {
        if (body instanceof SuccessResponseDto || body instanceof ResponseEntity) {
            return body;
        }

        SuccessResponseDto<Object> successResponse = new SuccessResponseDto<>();
        successResponse.setStatus(RespStatus.OK);
        successResponse.setResult(body);
        successResponse.setDescription("Request was successful");

        return successResponse;
    }
}