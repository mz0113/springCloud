package mz.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.ApplicationContext;
import rule.MyRibbonRule;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="CLOUD-PAYMENT-SERVICE",configuration = MyRibbonRule.class)
public class OrderMain80 {
    static ApplicationContext applicationContext;
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}
