package mz.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import mz.springcloud.entities.CommonResult;
import mz.springcloud.entities.Payment;
import mz.springcloud.service.PaymentService;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("******插入结果:"+result);
        if (result>0) {
            return new CommonResult(200,"插入数据库成功",result);
        }else{
            return new CommonResult<>(444,"插入数据库失败",null);
        }
    }

    @GetMapping(value = "payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("******查询结果:"+payment);
        if (payment!=null) {
            return new CommonResult(200,"查询成功",payment);
        }else{
            return new CommonResult<>(444,"未查询到记录",null);
        }
    }

    @GetMapping(value = "payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        services.forEach(t->log.info(t));

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(t->log.info(t.getHost()+" "+t.getPort()+" "+t.getUri()));

        return discoveryClient;
    }
}
