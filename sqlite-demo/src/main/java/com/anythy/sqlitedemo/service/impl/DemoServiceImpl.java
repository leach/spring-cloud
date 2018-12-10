package com.anythy.sqlitedemo.service.impl;

import com.anythy.sqlitedemo.mapper.DemoMapper;
import com.anythy.sqlitedemo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author leach
 */
@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    DemoMapper demoMapper;
    /**
     * demo query
     * @author leach
     * @param num
     * @return
     */
    @Override
    public List<Map<String, Object>> queryItem(int num){
        return demoMapper.queryItem(num);
    }
}
