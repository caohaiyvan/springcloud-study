package com.chy.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author chy
 * @date 2020/5/24 10:17
 */
@Configuration
public class RestTemplateConfig {

  @Bean
  @LoadBalanced // 使用@LoadBalanced注解赋予了RestTemplate负载均衡的能力
  public RestTemplate getRestTemplate() {
    return new RestTemplate();
  }
}
