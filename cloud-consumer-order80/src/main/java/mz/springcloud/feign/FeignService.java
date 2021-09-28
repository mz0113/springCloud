package mz.springcloud.feign;

import mz.springcloud.entities.CommonResult;
import mz.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CLOUD-PAYMENT-SERVICE")
public interface FeignService {

    @GetMapping(value = "payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
}
