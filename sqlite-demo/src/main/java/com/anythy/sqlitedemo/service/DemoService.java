package com.anythy.sqlitedemo.service;

import java.util.List;
import java.util.Map;

/**
 * @author leach
 */
public interface DemoService {

    /**
     * demo query
     * @author leach
     * @param num
     * @return
     */
    List<Map<String, Object>> queryItem(int num);
}
