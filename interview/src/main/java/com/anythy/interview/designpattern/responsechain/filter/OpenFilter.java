package com.anythy.interview.designpattern.responsechain.filter;

import com.anythy.interview.designpattern.responsechain.Request;
import com.anythy.interview.designpattern.responsechain.Response;

public class OpenFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        request.setRequestStr(request.getRequestStr().replaceAll("open", "[OPEN]")
                + "$OF$ ");
        filterChain.doFilter(request, response, filterChain);
        response.setResponseStr(response.getResponseStr() + "$OF$ ");
    }
}
