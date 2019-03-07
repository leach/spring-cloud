package com.anythy.interview.designpattern.responsechain.filter;

import com.anythy.interview.designpattern.responsechain.Request;
import com.anythy.interview.designpattern.responsechain.Response;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter {
    //用List集合来存储过滤规则
    List<Filter> filters = new ArrayList<Filter>();
    //用于标记规则的引用顺序
    private int index = 0;

    public FilterChain addFilter(Filter filter){
        filters.add(filter);
        return this;
    }

    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        if(index == filters.size()){
            return;
        }
        Filter filter = filters.get(index);
        index ++;
        filter.doFilter(request, response, filterChain);
    }
}
