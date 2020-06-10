package com.chy.springcloud.controller;

import com.chy.springcloud.entities.CommonResult;
import com.chy.springcloud.entities.Payment;
import com.chy.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author chy
 * @date 2020/5/23 20:07
 */
@RestController
@Slf4j
public class PaymentController {
  @Resource private PaymentService paymentService;

  @Value("${server.port}")
  private String serverPort;

  @PostMapping("/payment/create")
  public CommonResult create(@RequestBody Payment payment) {
    int result = paymentService.create(payment);
    log.info("结果：" + result);
    if (result > 0) {
      return new CommonResult(200, "保存成功 serverPort: " + serverPort, result);
    }
    return new CommonResult(444, "保存失败 serverPort:" + serverPort, null);
  }

  @GetMapping("/payment/get/{id}")
  public CommonResult getPaymentById(@PathVariable String id) {
    Payment payment = paymentService.getPaymentById(id);
    log.info("结果：" + payment);
    if (payment != null) {
      return new CommonResult(200, "查询成功serverPort: " + serverPort, payment);
    }
    return new CommonResult(444, "查询失败serverPort: " + serverPort, null);
  }
}
