package com.lingh.test.controller;

import com.lingh.test.db.dao.TestMapper;
import com.lingh.test.db.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class TestController {

    @Autowired
    TestMapper testMapper;

    @GetMapping("/test")
    public String test() {
        return "hello world";
    }

    @GetMapping("add")
    public String add() {
        Test test = new Test();
        test.setName("name");
        testMapper.insert(test);
        return "success";
    }

    @GetMapping("get")
    public Test get() {
        return testMapper.selectByPrimaryKey(1);
    }
}
