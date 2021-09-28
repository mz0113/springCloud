package mz.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import mz.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @RequestMapping(value = "paymentHystrix/ok")
    public int paymentOk(){
        return paymentService.paymentOk();
    }

    @RequestMapping(value = "paymentHystrix/timeout")
    public int paymentTimeout(){
        return paymentService.paymentTimeout();
    }
}
