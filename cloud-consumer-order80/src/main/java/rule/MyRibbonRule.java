package rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 官方说ribbon要替换自定义rule的话不能将其放到@ComponentScan能扫到的地方，否则配置将会被所有Ribbon Client共享
 */
@Configuration
public class MyRibbonRule  {
    @Bean
    IRule myRule(){
        return new RoundRobinRule();
    }
}
