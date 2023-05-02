package SiG.demo;

import SiG.demo.Config.AppConfig;
import SiG.demo.Config.PureJavaConfig;
import SiG.demo.UserService.SingletonService;
import SiG.demo.UserService.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

    @Test
    @DisplayName("순수한 자바 Config 파일")
    void pureJavaDependency() {
        PureJavaConfig pureJavaConfig = new PureJavaConfig();

        //1. 조회: 호출할 떄 마다 객체 생성
        UserService userService = pureJavaConfig.userService();

        //2. 조회: 호출할 떄 마다 객체 생성
        UserService userService1 = pureJavaConfig.userService();

        //실제 참조값이 다른 것을 확인(메모리의 다른 장소에 저장되었다는 것!!!)
        System.out.println("userService = " + userService);
        System.out.println("userService1 = " + userService1);
    }

    @Test
    @DisplayName("스프링이 아닌 순수한 DI 컨테이너")
    void notSpringContainer() {
        AppConfig appConfig = new AppConfig();

        //1. 조회: 호출할 떄 마다 객체 생성
        UserService userService = appConfig.userService();

        //2. 조회: 호출할 떄 마다 객체 생성
        UserService userService1 = appConfig.userService();

        //실제 참조값이 다른 것을 확인(메모리의 다른 장소에 저장되었다는 것!!!)
        System.out.println("userService = " + userService);
        System.out.println("userService1 = " + userService1);
    }

     @Test
    @DisplayName("싱글톤 패턴 테스트")
    void SingletonTest() {

        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        assertThat(singletonService1).isSameAs(singletonService2);
    }

    @Test
    @DisplayName("싱글톤 패턴 테스트 2")
    void SingletonTest2() {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //ApplicationContext 인터페이스를 통해 Bean 호출

        UserService userService = applicationContext.getBean("userService", UserService.class);
        UserService userService1 = applicationContext.getBean("userService", UserService.class);

        System.out.println("첫 번째 UserService = " + userService);
        System.out.println("두 번째 UserService = " + userService1);
        assertThat(userService).isSameAs(userService1);

    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = ac.getBean("userService", UserService.class);
        UserService userService1 = ac.getBean("userService", UserService.class); //Spring Container 통한 객체 2개 생성

        System.out.println("userService = " + userService);
        System.out.println("userService1 = " + userService1);

        assertThat(userService1).isSameAs(userService); //생성된 객체가 똑같은 곳을 참조하고 있는지 확인

    }
}



