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

@Configuration
public class AppConfig {

    @Bean
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
