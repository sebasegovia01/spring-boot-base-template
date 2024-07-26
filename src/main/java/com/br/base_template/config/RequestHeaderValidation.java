package com.br.base_template.config;

import com.br.base_template.dto.RequestHeaderDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;

import java.text.SimpleDateFormat;
import java.util.Date;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RequestHeaderValidation {

    @ModelAttribute
    public RequestHeaderDto validateAndPopulateHeaders(
            @RequestHeader(value = "Consumer-Sys-Code", required = true) String consumerSysCode,
            @RequestHeader(value = "Consumer-Enterprise-Code", required = true) String consumerEnterpriseCode,
            @RequestHeader(value = "Consumer-Country-Code", required = true) String consumerCountryCode,
            @RequestHeader(value = "Trace-Client-Req-Timestamp", required = false) String traceClientReqTimestamp,
            @RequestHeader(value = "Trace-Source-Id", required = false) String traceSourceId,
            @RequestHeader(value = "Trace-Event-Id", required = false) String traceEventId,
            @RequestHeader(value = "Channel-Name", required = false) String channelName,
            @RequestHeader(value = "Channel-Mode", required = false) String channelMode,
            HttpServletRequest request
    ) {
        RequestHeaderDto headers = new RequestHeaderDto();
        headers.setConsumerSysCode(consumerSysCode);
        headers.setConsumerEnterpriseCode(consumerEnterpriseCode);
        headers.setConsumerCountryCode(consumerCountryCode);
        headers.setTraceClientReqTimestamp(traceClientReqTimestamp);
        headers.setTraceSourceId(traceSourceId);
        headers.setTraceEventId(traceEventId);
        headers.setChannelName(channelName);
        headers.setChannelMode(channelMode);

        return headers;
    }
}
