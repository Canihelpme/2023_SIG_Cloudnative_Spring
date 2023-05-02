package SiG.demo;

import SiG.demo.Config.AppConfig;
import SiG.demo.Entity.User;
import SiG.demo.UserService.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonApplication {

    public static void main(String[] args) {
        SingletonApp();
    }
    public static void SingletonApp() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = applicationContext.getBean("userService", UserService.class);
        UserService userService1 = applicationContext.getBean("userService", UserService.class);
        System.out.println("첫 번째 UserService = " + userService);
        System.out.println("두 번째 UserService = " + userService1);

    }
}
