package com.chy.springcloud;

import com.chy.myrule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author chy
 * @date 2020/5/24 10:05
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "PAYMENT-PROVIDER", configuration = MyRule.class)
public class OrderMain {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain.class,args);
    }
}
