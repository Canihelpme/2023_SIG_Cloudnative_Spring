package SiG.demo;

import SiG.demo.Product.ProductRegist;
import SiG.demo.Product.ProductRegistImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,
        classes = Configuration.class))
public class AutoAppConfig {

    @Bean
    public ProductRegist productRegistImpl() {
        return new ProductRegistImpl();
    }

}




