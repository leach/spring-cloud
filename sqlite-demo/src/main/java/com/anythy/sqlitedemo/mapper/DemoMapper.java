package com.anythy.sqlitedemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author leach
 */
@Mapper
@Component
public interface DemoMapper {

    /**
     * demo query
     * @author leach
     * @param num
     * @return
     */
    @Select("select * from item order by id desc limit 1")
    List<Map<String, Object>> queryItem(int num);
}
