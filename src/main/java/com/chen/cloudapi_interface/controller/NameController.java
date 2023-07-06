package com.chen.cloudapi_interface.controller;

import com.chen.cloudapi_interface.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 名称 API
 *
 * @author Cloud
 */
@Slf4j
@RestController
@RequestMapping("/name")
public class NameController {

    @GetMapping("/")
    public String getNameByGet(String name) {
        log.error("错误为:{}",name);
        return "GET 你的名字是" + name;
    }

    @PostMapping("/")
    public String getNameByPost(@RequestParam String name) {
        log.error("错误为:{}",name);
        return "POST 你的名字是" + name;
    }

    @PostMapping("/user")
    public String getUsernameByPost(@RequestBody User user) {
        log.error("错误为:{}",user.getUsername());
        return "POST 用户名字是" + user.getUsername();
    }
}
