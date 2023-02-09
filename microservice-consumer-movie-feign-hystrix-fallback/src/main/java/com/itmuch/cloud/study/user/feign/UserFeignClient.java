package com.itmuch.cloud.study.user.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itmuch.cloud.study.user.entity.User;

/**
 * Feign接口
 *
 * @author sunk
 * @date 2022/2/26
 */
@FeignClient(name = "microservice-provider-user", fallback = FeignClientFallback.class)
public interface UserFeignClient {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User findByid(@PathVariable("id") Long id);
}

@Component
class FeignClientFallback implements UserFeignClient{

    @Override
    public User findByid(Long id) {
        User user = new User();
        user.setId(-1L);
        user.setUsername("默认用户");
        return user;
    }
}