package com.chy.springcloud.service;

import com.chy.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author chy
 * @date 2020/5/23 19:59
 */

public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") String id);

    Payment timeout(@Param("id") String id);

    String paymentCircuitBreaker(@Param("id") String id);
}
