package com.anythy.interview.designpattern.responsechain.filter;

import com.anythy.interview.designpattern.responsechain.Request;
import com.anythy.interview.designpattern.responsechain.Response;

public class WorldFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        request.setRequestStr(request.getRequestStr().replaceAll("world", "[WORLD]")
                + "$WF$ ");
        filterChain.doFilter(request, response, filterChain);
        response.setResponseStr(response.getResponseStr() + "$WF$ ");
    }
}
