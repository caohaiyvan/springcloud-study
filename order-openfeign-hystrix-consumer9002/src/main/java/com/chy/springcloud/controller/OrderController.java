package com.chy.springcloud.controller;

import com.chy.springcloud.entities.CommonResult;
import com.chy.springcloud.entities.Payment;
import com.chy.springcloud.service.ConsumerService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chy
 * @date 2020/5/24 10:09
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "timeOutHandler")
public class OrderController {
  @Autowired private ConsumerService consumerService;

  @GetMapping("/order/payment/get/{id}")
  public CommonResult<Payment> getPaymentById(@PathVariable(value = "id") String id) {
    return consumerService.getPaymentById(id);
  }

  @GetMapping("/order/hystrix/timeout/{id}")
  @HystrixCommand
          (
      fallbackMethod = "timeOutHandler",
      commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
      })
  public CommonResult timeout(@PathVariable String id) {
    return consumerService.timeout(id);
  }

  public CommonResult timeOutHandler() {
    return new CommonResult(null,"timeOutHandler客户端服务降级/(ㄒoㄒ)/~~",null);
  }
}
