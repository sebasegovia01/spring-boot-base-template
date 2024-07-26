package com.br.base_template.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class RequestHeaderDto {

    @NotBlank(message = "Consumer-Sys-Code is mandatory")
    private String consumerSysCode;

    @NotBlank(message = "Consumer-Enterprise-Code is mandatory")
    private String consumerEnterpriseCode;

    @NotBlank(message = "Consumer-Country-Code is mandatory")
    private String consumerCountryCode;

    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}\\.\\d{6}[+-]\\d{4}", message = "Trace-Client-Req-Timestamp must be in yyyy-MM-dd HH:mm:ss.SSSSSSZ format")
    private String traceClientReqTimestamp;

    private String traceSourceId;
    private String traceEventId;
    private String channelName;
    private String channelMode;

    // Getters and Setters
    public String getConsumerSysCode() {
        return consumerSysCode;
    }

    public void setConsumerSysCode(String consumerSysCode) {
        this.consumerSysCode = consumerSysCode;
    }

    public String getConsumerEnterpriseCode() {
        return consumerEnterpriseCode;
    }

    public void setConsumerEnterpriseCode(String consumerEnterpriseCode) {
        this.consumerEnterpriseCode = consumerEnterpriseCode;
    }

    public String getConsumerCountryCode() {
        return consumerCountryCode;
    }

    public void setConsumerCountryCode(String consumerCountryCode) {
        this.consumerCountryCode = consumerCountryCode;
    }

    public String getTraceClientReqTimestamp() {
        return traceClientReqTimestamp;
    }

    public void setTraceClientReqTimestamp(String traceClientReqTimestamp) {
        this.traceClientReqTimestamp = traceClientReqTimestamp;
    }

    public String getTraceSourceId() {
        return traceSourceId;
    }

    public void setTraceSourceId(String traceSourceId) {
        this.traceSourceId = traceSourceId;
    }

    public String getTraceEventId() {
        return traceEventId;
    }

    public void setTraceEventId(String traceEventId) {
        this.traceEventId = traceEventId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelMode() {
        return channelMode;
    }

    public void setChannelMode(String channelMode) {
        this.channelMode = channelMode;
    }
}
