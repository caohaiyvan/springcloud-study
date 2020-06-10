package com.chy.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.chy.springcloud.dao.PaymentDao;
import com.chy.springcloud.entities.Payment;
import com.chy.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author chy
 * @date 2020/5/23 20:01
 */
@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {
  @Resource private PaymentDao paymentDao;

  @Override
  public int create(Payment payment) {
    return paymentDao.create(payment);
  }

  @Override
  public Payment getPaymentById(String id) {
    return paymentDao.getPaymentById(id);
  }

  @Override
  @HystrixCommand(
      fallbackMethod = "getPaymentByIdTimeOutHandler",
      commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
      })
  public Payment timeout(String id) {
    try {
      TimeUnit.SECONDS.sleep(5);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return paymentDao.getPaymentById(id);
  }

  @Override
  @HystrixCommand(fallbackMethod = "circuitHandler",commandProperties = {
          @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
          @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),   //请求次数
          @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //时间范围
          @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少后跳闸
  })
  public String paymentCircuitBreaker(@PathVariable("id") String id){
    if ("null".equals(id)){
      throw new RuntimeException("*****id 不能为空");
    }
    String serialNumber = IdUtil.simpleUUID();

    return Thread.currentThread().getName()+"\t"+"调用成功,流水号："+serialNumber;
  }

  public Payment getPaymentByIdTimeOutHandler(String id) {
    log.info("服务降级。。。。。。。。。");
    return null;
  }

  public String circuitHandler(String id) {
    return "服务熔断-----------------";
  }
}
