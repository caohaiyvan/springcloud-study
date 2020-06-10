package com.chy.springcloud.service;

import com.chy.springcloud.entities.CommonResult;
import com.chy.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author chy
 * @date 2020/5/28 8:52
 */
@FeignClient("PAYMENT-PROVIDER")
@Component
public interface ConsumerService {
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable(value = "id") String id);
}
