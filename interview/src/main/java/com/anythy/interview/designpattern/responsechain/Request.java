package com.anythy.interview.designpattern.responsechain;

public class Request {
    private String requestStr;

    public Request(String requestStr) {
        this.requestStr = requestStr;
    }

    public String getRequestStr() {
        return requestStr;
    }

    public void setRequestStr(String requestStr) {
        this.requestStr = requestStr;
    }
}
