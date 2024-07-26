package com.br.base_template.config;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ResponseHeader {

    private String traceReqTimestamp;
    private String traceRspTimestamp;
    private String traceSourceId;
    private String localTransactionId;

    // Constructor with all fields
    public ResponseHeader(String traceReqTimestamp, String traceRspTimestamp, String traceSourceId, String localTransactionId) {
        this.traceReqTimestamp = traceReqTimestamp;
        this.traceRspTimestamp = traceRspTimestamp;
        this.traceSourceId = traceSourceId;
        this.localTransactionId = localTransactionId;
    }

    // Getters and Setters
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

    // Helper method to generate current timestamp
    public static String getCurrentTimestamp() {
        return ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSZ"));
    }
}
