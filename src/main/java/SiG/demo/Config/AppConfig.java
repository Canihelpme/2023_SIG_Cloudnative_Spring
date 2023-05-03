package SiG.demo.Config;

import SiG.demo.EncodeUtil.EnforcedEncoder;
import SiG.demo.EncodeUtil.PasswordEncoder;
import SiG.demo.Repository.MemoryUserRepository;
import SiG.demo.Repository.UserRepository;
import SiG.demo.UserService.UserModifyService;
import SiG.demo.UserService.UserModifyServiceImpl;
import SiG.demo.UserService.UserService;
import SiG.demo.UserService.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Java Configuration 방식으로 Bean 등록
 */
@Configuration //Configuration Annotation 을 통해 Spring이 설정 파일을 참조 할 수 있도록 선언
public class AppConfig {

    @Bean //Bean annotation 으로 Spring에게 Bean으로 등록해달라고 요청
    public PasswordEncoder passwordEncoder() {
        return new EnforcedEncoder();
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl(userRepository(), passwordEncoder());
    }

    @Bean
    public UserModifyService userModifyService() { return new UserModifyServiceImpl(userRepository());}

    @Bean
    public UserRepository userRepository() {
        return new MemoryUserRepository();
    }

    @Bean
    public UserRepository userRepository1() {return new MemoryUserRepository();}

}
