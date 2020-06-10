package com.chy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chy
 * @date 2020/5/24 10:05
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderMain8006 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain8006.class,args);
    }
}
