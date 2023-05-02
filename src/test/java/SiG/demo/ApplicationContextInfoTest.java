package SiG.demo;

import SiG.demo.Config.AppConfig;
import SiG.demo.Repository.UserRepository;
import SiG.demo.UserService.UserService;
import SiG.demo.UserService.UserServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name=" + beanDefinitionName + "object=" + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition= ac.getBeanDefinition(beanDefinitionName);

            //getBean과는 다르게 bean의 메타데이터를 모두 꺼내옴
            //Role 구분을 통해 Application에서 실제 생성한 빈만 호출
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("name=" + beanDefinitionName + "object=" + beanDefinition);
            }
        }
    }

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        UserService userService = ac.getBean("userService", UserService.class);
        System.out.println("userService = " + userService);
        System.out.println("userService.getClass() = " + userService.getClass()); //userService의 반환 클래스 확인
        assertThat(userService).isInstanceOf(UserServiceImpl.class); //userSerivce가 UserServiceImpl을 반환하면 성공
    }

    @Test
    @DisplayName("타입으로만 조회")
    void findBeanByType() {
        UserService userService = ac.getBean(UserService.class);
        assertThat(userService).isInstanceOf(UserServiceImpl.class); //userSerivce가 UserServiceImpl을 반환하면 성공
    }

    @Test
    @DisplayName("구현체 타입으로만 조회")
    void findBeanByImpl() {
        UserServiceImpl userService = ac.getBean("userService", UserServiceImpl.class);
        assertThat(userService).isInstanceOf(UserServiceImpl.class);
    } //bean의 타입을 결정할 때 꼭 반환되는 것의 타입을 보고 결정하기 때문에, 인터페이스가 아니더라도 구현체로도 조회가 가능하다.
      // 물론 구체에 의존하는 것은 좋지 않다...

    @Test
    @DisplayName("빈 이름으로 조회했는데 없다면?!?!?")
    void findBeanByNameX() {
        //UserService xxxx = ac.getBean("xxxx", UserService.class); NoSuchBeanDefinitionException 발생
        org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxx", UserService.class));
    }

    @Test
    @DisplayName("같은 타입의 빈이 여러개 있으면 중복 오류가 발생")
    void findBeanByTypeDuplicate() {
        UserRepository bean = ac.getBean(UserRepository.class);
    }


    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 빈 이름으로 조회")
    void findSameTypeBeanByName() {
        UserRepository userRepository = ac.getBean("userRepository1", UserRepository.class);
        assertThat(userRepository).isInstanceOf(UserRepository.class);
    }


    @Test
    @DisplayName("특정 타입을 모두 조회하기")
    void findAllSameTypeBean() {
        Map<String,UserRepository> beansOfType = ac.getBeansOfType(UserRepository.class);
        for(String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }
        System.out.println("beansOfType = " + beansOfType);
        assertThat(beansOfType.size()).isEqualTo(2);
    }

}
