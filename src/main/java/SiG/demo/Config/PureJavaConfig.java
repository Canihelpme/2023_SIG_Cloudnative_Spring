package SiG.demo.Config;

import SiG.demo.EncodeUtil.EnforcedEncoder;
import SiG.demo.EncodeUtil.PasswordEncoder;
import SiG.demo.Repository.Memory2UserRepository;
import SiG.demo.Repository.MemoryUserRepository;
import SiG.demo.Repository.UserRepository;
import SiG.demo.UserService.UserService;
import SiG.demo.UserService.UserServiceImpl;


public class PureJavaConfig {

    public PasswordEncoder passwordEncoder() {
        return new EnforcedEncoder();
    }

    public UserService userService() {
        return new UserServiceImpl(userRepository(), passwordEncoder());
    }

    public UserRepository userRepository() {
        return new MemoryUserRepository();
    }

    public UserRepository userRepository1() {return new MemoryUserRepository();}

}
