package com.anythy.interview.designpattern.responsechain;

public class Response {
    private String responseStr;

    public Response(String responseStr) {
        this.responseStr = responseStr;
    }

    public String getResponseStr() {
        return responseStr;
    }

    public void setResponseStr(String responseStr) {
        this.responseStr = responseStr;
    }
}
