package com.wenwu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lvchuan on 17/6/29.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @RequestMapping("/login")
    public Object login() {
        logger.info("user login");
        return null;
    }
}
