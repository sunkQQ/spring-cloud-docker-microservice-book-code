package com.itmuch.cloud.study.user.feign;

import com.itmuch.cloud.config.FeignConfiguration;
import com.itmuch.cloud.study.user.entity.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 使用@FeignClient的configurationg属性，指定feign的配置类
 *
 * @author sunk
 * @date 2022/2/26
 */
@FeignClient(name = "microservice-provider-user", configuration = FeignConfiguration.class)
public interface UserFeignClient {


    /**
     * 使用feign自带的注解@RequestLine
     * @param id
     * @return
     */
    @RequestLine("GET /{id}")
    public User findById(@Param("id") Long id);
}
