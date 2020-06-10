package com.chy.springcloud.controller;

import com.chy.springcloud.entities.CommonResult;
import com.chy.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import com.chy.springcloud.service.PaymentService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chy
 * @date 2020/5/23 20:07
 */
@RestController
@Slf4j
public class PaymentController {
  @Resource private PaymentService paymentService;
  @Resource private DiscoveryClient discoveryClient;

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

    /**
     * 服务发现Discovery
   * @return
     */
  @GetMapping("/payment/discovery")
  public Object discovery() {
    /*
    这个services是指的:所有的微服务注册的名称
    */
    List<String> services = discoveryClient.getServices();
    for (String element : services) {
      log.info("******element:" + element);
    }
    List<ServiceInstance> instances = discoveryClient.getInstances("PAYMENT-PROVIDER");
    for (ServiceInstance instance : instances) {
      log.info(
          "*****serverId："
              + instance.getServiceId()
              + "\t"
              + "host:"
              + instance.getHost()
              + "\t"
              + "port:"
              + instance.getPort());
    }
    return this.discoveryClient;
  }
}
