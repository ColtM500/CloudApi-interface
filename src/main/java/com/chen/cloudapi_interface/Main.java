package com.chen.cloudapi_interface;

import com.chen.cloudapi_interface.client.CloudApiClient;
import com.chen.cloudapi_interface.model.User;

public class Main {
    public static void main(String[] args) {
        String accessKey = "nmsl";
        String secretKey = "ndsl";
        CloudApiClient client = new CloudApiClient();
        String result1 = client.getNameByGet("cloud");
        String result2 = client.getNameByPost("cloud");
        User user = new User();
        user.setUsername("sb1");
        String result3 = client.getUserNameByPost(user);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }
}
