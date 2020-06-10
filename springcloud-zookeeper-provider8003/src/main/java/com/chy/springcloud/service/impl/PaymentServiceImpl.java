package com.chy.springcloud.service.impl;

import com.chy.springcloud.dao.PaymentDao;
import com.chy.springcloud.entities.Payment;
import org.springframework.stereotype.Service;
import com.chy.springcloud.service.PaymentService;

import javax.annotation.Resource;

/**
 * @author chy
 * @date 2020/5/23 20:01
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(String id) {
        return paymentDao.getPaymentById(id);
    }
}
