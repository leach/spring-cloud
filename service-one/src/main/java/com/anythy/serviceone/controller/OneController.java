package com.anythy.serviceone.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author leach
 */
@RestController
@RequestMapping("test")
public class OneController {

    @RequestMapping("i")
    public String test(){
        return "test/one";
    }
}
