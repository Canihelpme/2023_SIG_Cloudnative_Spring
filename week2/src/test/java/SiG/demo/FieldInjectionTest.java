package SiG.demo;

import SiG.demo.EncodeUtil.EnforcedEncoder;
import SiG.demo.Repository.MemoryUserRepository;
import SiG.demo.UserService.UserService;
import SiG.demo.UserService.UserServiceImpl;
import org.junit.jupiter.api.Test;

public class FieldInjectionTest {

    @Test
    void createUser() {

        //UserService userService = new UserServiceImpl(userRepository, passwordEncoder);

        UserService userService = new UserServiceImpl(new MemoryUserRepository(), new EnforcedEncoder());

        userService.addUser(1L, "donghyun", "donghyun", "abc135!!");
    }
}


