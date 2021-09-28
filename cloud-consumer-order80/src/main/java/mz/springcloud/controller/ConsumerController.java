package mz.springcloud.controller;

import mz.springcloud.entities.CommonResult;
import mz.springcloud.entities.Payment;
import mz.springcloud.feign.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ConsumerController {
    @Resource
    RestTemplate restTemplate;

    @Autowired
    FeignService feignService;

    static final String CREARE_URL = "http://CLOUD-PAYMENT-SERVICE";
    static final String GET_URL = "http://CLOUD-PAYMENT-SERVICE";

    @PostMapping(value = "consumer/create")
    public CommonResult<Integer> create(@RequestBody Payment payment){
        CommonResult commonResult = restTemplate.postForObject(CREARE_URL+"/payment/create", payment, CommonResult.class);
        return commonResult;
    }

    @GetMapping(value = "consumer/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        CommonResult object = restTemplate.getForObject(GET_URL+"/payment/get/{id}", CommonResult.class,id);
        return object;
    }

    @GetMapping(value = "consumer/getForEntity/{id}")
    public CommonResult<Payment> getPaymentById2(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(GET_URL + "/payment/get/{id}", CommonResult.class, id);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return new CommonResult(200,entity.getBody());
        }else{
            return new CommonResult(444, "请求失败");
        }
    }

    @PostMapping(value = "consumerEntity/create")
    public CommonResult<Integer> create2(@RequestBody Payment payment){
        ResponseEntity<CommonResult>  entity = restTemplate.postForEntity(CREARE_URL+"/payment/create", payment, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return new CommonResult(200,entity.getBody());
        }else{
            return new CommonResult(444, "请求失败");
        }
    }

    @GetMapping(value = "consumer/getFeign/{id}")
    public CommonResult<Payment> getFeign(@PathVariable("id") Long id){
        CommonResult object = feignService.getPaymentById(id);
        return object;
    }

    /**
     * 默认超时1秒钟,可yaml配置
     */
    @GetMapping(value = "consumer/getFeignTimeOut/{id}")
    public CommonResult<Payment> getFeignTimeOut(@PathVariable("id") Long id){
        CommonResult object = feignService.getPaymentById(id);
        return object;
    }
}
