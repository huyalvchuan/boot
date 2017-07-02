package com.wenwu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lvchuan on 17/6/28.
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
