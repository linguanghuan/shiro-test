package com.lingh.test.controller;

import com.lingh.test.db.dao.TestMapper;
import com.lingh.test.db.entity.Test;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@Slf4j
public class TestController {

    @Autowired
    TestMapper testMapper;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate jsonRedisTemplate;

    @GetMapping("/hello")
    public String test() {
        return "hello world";
    }

    @GetMapping("/add")
    public String add() {
        Test test = new Test();
        test.setName("name");
        testMapper.insert(test);
        return "success";
    }

    @GetMapping("/get")
    public Test get() {
        return testMapper.selectByPrimaryKey(1);
    }

    @GetMapping("/redis")
    public String redis() {
        redisTemplate.opsForValue().set("test", "value111");
        stringRedisTemplate.opsForValue().set("stringkey", "stringvalue");
        Test test = new Test();
        test.setId(1);
        test.setName("111");
        jsonRedisTemplate.opsForValue().set("object", test);
        Test testFromRedis = (Test) jsonRedisTemplate.opsForValue().get("object");
        log.info("value from redis:{}", testFromRedis.getName());
        return (String) redisTemplate.opsForValue().get("test");
    }

    @GetMapping("/login")
    public String login() {
        Subject subject = SecurityUtils.getSubject();
        boolean authenticated = subject.isAuthenticated();
        log.info("authenticated:{}", authenticated);
        if (authenticated) {
            return "already login";
        }

        UsernamePasswordToken token = new UsernamePasswordToken("admin", "123456");
        try {
            subject.login(token);
        } catch (LockedAccountException lae) {
            token.clear();
            return "failed: locked account";
        } catch (AuthenticationException e) {
            token.clear();
            return "failed";
        }
        return "succeed";
    }
}
