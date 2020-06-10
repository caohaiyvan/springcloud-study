package com.chy.springcloud.controller;

import com.chy.springcloud.entities.CommonResult;
import com.chy.springcloud.entities.Payment;
import com.chy.springcloud.service.ConsumerService;
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

public class OrderController {
  @Autowired
  private ConsumerService consumerService;
  @GetMapping("/order/payment/get/{id}")
  public CommonResult<Payment> getPaymentById(@PathVariable(value = "id") String id){
    return consumerService.getPaymentById(id);
  }

}
