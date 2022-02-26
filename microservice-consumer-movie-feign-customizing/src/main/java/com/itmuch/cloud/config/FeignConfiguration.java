package com.itmuch.cloud.config;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 该类为feign的配置类
 * 注意：该类不应该在主应用程序上下文的@ComponentScan中
 *
 * @author sunk
 * @date 2022/2/26
 */
@Configuration
public class FeignConfiguration {


    /**
     * 将契约改为feign原生的默认契约。这样就可以使用feign自带的注解了。
     * @return
     */
    @Bean
    public Contract feignContract(){
        return new Contract.Default();
    }
}
