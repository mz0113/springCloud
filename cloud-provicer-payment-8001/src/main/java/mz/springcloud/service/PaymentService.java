package mz.springcloud.service;

import mz.springcloud.entities.Payment;

public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById( Long id);
}
