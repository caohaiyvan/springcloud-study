package com.chy.springcloud.controller;

import com.chy.springcloud.entities.CommonResult;
import com.chy.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author chy
 * @date 2020/5/24 10:09
 */
@RestController
@Slf4j
public class OrderController {
  @Resource
  private RestTemplate restTemplate;
  private static final String PAYMENT_URL = "http://springcloud-zookeeper-provider8003/";

  @GetMapping("/order/get/{id}")
  public CommonResult<Payment> getPaymentById(@PathVariable String id) {
    return restTemplate.getForObject(PAYMENT_URL + "payment/get/" + id, CommonResult.class);
  }

  @GetMapping("/order/create")
  public CommonResult<Payment> create(Payment payment) {
    return restTemplate.postForObject(PAYMENT_URL + "payment/create", payment, CommonResult.class);
  }
}
