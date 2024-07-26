package com.br.base_template.dto;

public class ResponseHeaderDto {
    private String traceReqTimestamp;
    private String traceRspTimestamp;
    private String traceSourceId;
    private String localTransactionId;

    public String getTraceReqTimestamp() {
        return traceReqTimestamp;
    }

    public void setTraceReqTimestamp(String traceReqTimestamp) {
        this.traceReqTimestamp = traceReqTimestamp;
    }

    public String getTraceRspTimestamp() {
        return traceRspTimestamp;
    }

    public void setTraceRspTimestamp(String traceRspTimestamp) {
        this.traceRspTimestamp = traceRspTimestamp;
    }

    public String getTraceSourceId() {
        return traceSourceId;
    }

    public void setTraceSourceId(String traceSourceId) {
        this.traceSourceId = traceSourceId;
    }

    public String getLocalTransactionId() {
        return localTransactionId;
    }

    public void setLocalTransactionId(String localTransactionId) {
        this.localTransactionId = localTransactionId;
    }
}
