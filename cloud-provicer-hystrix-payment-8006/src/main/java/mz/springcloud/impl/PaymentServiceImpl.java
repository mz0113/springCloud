package mz.springcloud.impl;

import mz.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;


@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public int paymentOk() {
        return 0;
    }

    @Override
    public int paymentTimeout() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
