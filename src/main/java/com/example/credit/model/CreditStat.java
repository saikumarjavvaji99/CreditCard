package com.example.credit.model;

import java.util.List;

public class CreditStat {

    Boolean success;
    int start;
    int limit;
    int size;
    List<Long> payload;


    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Long> getPayload() {
        return payload;
    }

    public void setPayload(List<Long> payload) {
        this.payload = payload;
    }
}
