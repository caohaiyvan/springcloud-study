package com.chy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author chy
 * @date 2020/5/24 10:05
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableFeignClients(basePackages = "com.chy.springcloud.service")
//@RibbonClient(name = "PAYMENT-PROVIDER", configuration = MyRule.class)
public class OrderMain9002 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain9002.class,args);
    }
}
