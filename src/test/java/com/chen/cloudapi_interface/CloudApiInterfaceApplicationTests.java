package com.chen.cloudapi_interface;


import com.chen.cloudapiclientsdk.client.CloudApiClient;
import com.chen.cloudapiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class CloudApiInterfaceApplicationTests {

    @Resource
    private CloudApiClient client;

    @Test
    void contextLoads(){
        String result = client.getNameByGet("chen");
        User user = new User();
        user.setUsername("chen");
        String userNameByPost = client.getUserNameByPost(user);
        System.out.println(result);
        System.out.println(userNameByPost);
    }
}
