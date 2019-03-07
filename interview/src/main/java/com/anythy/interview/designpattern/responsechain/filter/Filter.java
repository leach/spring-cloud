package com.anythy.interview.designpattern.responsechain.filter;

import com.anythy.interview.designpattern.responsechain.Request;
import com.anythy.interview.designpattern.responsechain.Response;

public interface Filter {

    void doFilter(Request request, Response response, FilterChain filterChain);
}
