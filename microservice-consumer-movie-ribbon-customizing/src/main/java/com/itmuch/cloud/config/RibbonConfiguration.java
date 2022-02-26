package com.itmuch.cloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 该类为bbon的配置类
 * 注意：该类不应该在主应用程序上下文的@ComponentScan中。
 *
 * @author sunk
 * @date 2022/2/26
 */
@Configuration
public class RibbonConfiguration {

    @Bean
    public IRule ribbonRule(){
        // 负载均衡规则，改为随机
        return new RandomRule();
    }
}
