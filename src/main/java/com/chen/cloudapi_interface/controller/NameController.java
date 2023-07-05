package com.chen.cloudapi_interface.controller;

import com.chen.cloudapi_interface.model.User;
import org.springframework.web.bind.annotation.*;

/**
 * 名称 API
 *
 * @author Cloud
 */
@RestController("/name")
public class NameController {

    @GetMapping("/")
    public String getNameByGet(String name) {
        return "GET 你的名字是" + name;
    }

    @PostMapping("/")
    public String getNameByPost(@RequestParam String name) {
        return "POST 你的名字是:" + name;
    }

    @PostMapping("/user")
    public String getUserNameByPost(@RequestBody User user) {
        return "POST 用户名是:" + user;
    }
}
