package SiG.demo.ComponentScanTest;

import SiG.demo.AutoAppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProductRegistTest {

    AnnotationConfigApplicationContext ac =
            new AnnotationConfigApplicationContext(AutoAppConfig.class);

    @Test
    @DisplayName("Component Scan 방법 확인 테스트")
    void ComponentScan() {

        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name=" + beanDefinitionName +
                    "| object=" + bean.getClass());
        }
    }
}
