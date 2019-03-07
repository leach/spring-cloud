package com.anythy.interview.designpattern.responsechain;

import com.anythy.interview.designpattern.responsechain.filter.FilterChain;
import com.anythy.interview.designpattern.responsechain.filter.HelloFilter;
import com.anythy.interview.designpattern.responsechain.filter.OpenFilter;
import com.anythy.interview.designpattern.responsechain.filter.WorldFilter;

public class TestChain {

    public static void main(String[] args) {
        String info = "helloworld";
        Request request = new Request(info);
        Response response = new Response("resp:");

        FilterChain filterChain = new FilterChain();
        filterChain.addFilter(new HelloFilter())
                .addFilter(new WorldFilter())
                .addFilter(new OpenFilter());

        filterChain.doFilter(request, response, filterChain);

        System.out.println(request.getRequestStr());
        System.out.println(response.getResponseStr());
    }
}
