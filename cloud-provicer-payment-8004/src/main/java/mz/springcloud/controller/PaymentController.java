package mz.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import mz.springcloud.entities.CommonResult;
import mz.springcloud.entities.Payment;
import mz.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "payment/zk")
    public String paymentZk(){
        return "with zk,port:"+port;
    }
}
