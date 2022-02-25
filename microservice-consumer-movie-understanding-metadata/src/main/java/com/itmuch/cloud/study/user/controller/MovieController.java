package com.itmuch.cloud.study.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.itmuch.cloud.study.user.entity.User;

import java.util.List;

/**
 * @Author sunk
 * @Date 2022/2/18
 */
@RestController
public class MovieController {

    @Value("user.userServiceUrl")
    private String userServiceUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return this.restTemplate.getForObject(this.userServiceUrl  + id, User.class);
    }

    /**
     * 查询microservice-provider-user服务的信息并返回
     * @return
     */
    @GetMapping("/user-instance")
    public List<ServiceInstance> showInfo(){
        return this.discoveryClient.getInstances("microservice-provider-user");
    }
}
