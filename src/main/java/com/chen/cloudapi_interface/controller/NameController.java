package com.chen.cloudapi_interface.controller;


import com.chen.cloudapiclientsdk.model.User;
import com.chen.cloudapiclientsdk.utils.SignUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 名称 API
 * 被人调用的接口
 *
 * @author Cloud
 */
@Slf4j
@RestController
@RequestMapping("/")
public class NameController {

    @GetMapping("/name")
    public String getNameByGet(String name, HttpServletRequest request) {
        System.out.println(request.getHeader("chen"));
        return "GET 你的名字是" + name;
    }

    @PostMapping("/")
    public String getNameByPost(@RequestParam String name) {
        log.error("错误为:{}",name);
        return "POST 你的名字是" + name;
    }

    @PostMapping("/user")
    public String getUsernameByPost(@RequestBody User user, HttpServletRequest request) {
        String accessKey = request.getHeader("accessKey");
        String nonce = request.getHeader("nonce");
        String timestamp = request.getHeader("timestamp");
        String sign = request.getHeader("sign");
        String body = request.getHeader("body");
        //TODO: 实际情况应该是数据库中的查是否已经分配给用户
        if (!accessKey.equals("nmsl")){
            throw new RuntimeException("无权限");
        }
        //这里不校验随机数了
        if (Long.parseLong(nonce)>10000) {
            throw new RuntimeException("无权限");
        }
        //TODO: 时间和当前时间不能超过5分钟
//        if (timestamp){
//
//        }
        //TODO: 实际情况中是从数据库中查出 secretKey
        String serverSign = SignUtils.getSign(body, "ndsl");
        if (!sign.equals(serverSign)){
            throw new RuntimeException("无权限");
        }
        //TODO: 调用成功后 次数+1

        String result = "POST 用户名字是" + user.getUsername();

        return result;
    }
}
