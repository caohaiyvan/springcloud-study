package com.chy.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author chy
 * @date 2020/5/23 18:34
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.chy.springcloud.dao")
public class PaymentMain8002 {
  public static void main(String[] args) {
      SpringApplication.run(PaymentMain8002.class,args);
  }
}
