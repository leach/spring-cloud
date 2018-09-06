package com.anythy.serviceone.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author leach
 */
@RestController
@RequestMapping("index")
public class OneController {

    @RequestMapping("test")
    public String test(){
        return "test/one";
    }
}
