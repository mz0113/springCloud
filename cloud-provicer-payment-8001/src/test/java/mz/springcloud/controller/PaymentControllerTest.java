package mz.springcloud.controller;

import static io.github.cweijan.mock.Mocker.*;

import io.github.cweijan.mock.Asserter;
import mz.springcloud.entities.CommonResult;
import mz.springcloud.entities.Payment;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import javax.annotation.Resource;

@io.github.cweijan.mock.jupiter.HttpTest
class PaymentControllerTest {

    @Resource
    private PaymentController paymentController;


    @Test
    @EnabledOnOs({OS.WINDOWS, OS.MAC})
    void create() {
        Payment payment = new Payment();
        payment.setSerial(mock(String.class));
        CommonResult<Integer> create = paymentController.create(payment);
        Asserter.assertNotNull(create);
    }
}
