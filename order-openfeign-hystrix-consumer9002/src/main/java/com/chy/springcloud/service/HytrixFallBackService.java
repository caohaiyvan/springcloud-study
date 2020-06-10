package com.chy.springcloud.service;

import com.chy.springcloud.entities.CommonResult;
import com.chy.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author chy
 * @date 2020/6/4 9:40
 */
@Component
public class HytrixFallBackService implements ConsumerService {
    @Override
    public CommonResult<Payment> getPaymentById(String id) {
        return null;
    }

    @Override
    public CommonResult timeout(String id) {
        return new CommonResult(null,"HytrixFallBackService，客户端降级");
    }
}
