package com.chy.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chy
 * @date 2020/5/27 12:43
 * 替换从服务列表中选取服务的算法
 */
@Configuration
public class MyRule {
    @Bean
    public IRule getRule(){
        return new RandomRule();
    }
}
