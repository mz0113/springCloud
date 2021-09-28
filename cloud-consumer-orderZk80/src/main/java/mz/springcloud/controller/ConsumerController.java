package mz.springcloud.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ConsumerController {
    @Resource
    RestTemplate restTemplate;

    //这里必须小写,要和application.yml中配置的一模一样,Eureka才可以大写
    static final String CREARE_URL = "http://cloud-payment-service";
    static final String GET_URL = "http://cloud-payment-service";

    @GetMapping(value = "/paymentInfo")
    public String paymentInfo(){
        return restTemplate.getForObject(GET_URL+"/payment/zk",String.class);
    }
}
