package com.anythy.sqlitedemo.controller;

import com.anythy.sqlitedemo.common.ConfigVar;
import com.anythy.sqlitedemo.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author leach
 */
@RestController
@RequestMapping("/demo")
@Slf4j
public class DemoController {
    @Autowired
    DemoService demoService;
    /**
     * demo query
     * @author leach
     * @param num
     * @return
     */
    @GetMapping("/query")
    public List<Map<String, Object>> query(int num){
        return demoService.queryItem(num);
    }

    @GetMapping("/run")
    public String runTask() throws InterruptedException {
        if(!ConfigVar.isRun.compareAndSet(false, true)){
            log.info("任务运行中：{}", Thread.currentThread().getId());
            return "任务运行中";
        }

        Thread.sleep(1000);
        ConfigVar.isRun.set(false);
        return "任务运行完成:" + Thread.currentThread().getId();
    }
}
