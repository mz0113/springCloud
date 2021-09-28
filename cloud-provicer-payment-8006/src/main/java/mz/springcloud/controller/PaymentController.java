package mz.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String port;


    @RequestMapping(value = "payment/consul")
    public String paymentZk(){
        return "with consul,port:"+port;
    }
}
