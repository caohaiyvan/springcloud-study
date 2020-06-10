package com.chy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author chy
 * @date 2020/5/24 15:56
 */
@SpringBootApplication
@EnableEurekaClient
public class Gateway8888 {
    public static void main(String[] args) {
        SpringApplication.run(Gateway8888.class,args);
    }
}
