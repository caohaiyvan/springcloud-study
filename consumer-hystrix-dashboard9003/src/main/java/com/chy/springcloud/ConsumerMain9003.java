package com.chy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author chy
 * @date 2020/5/24 10:05
 */
@SpringBootApplication
@EnableHystrixDashboard
public class ConsumerMain9003 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerMain9003.class,args);
    }
}
