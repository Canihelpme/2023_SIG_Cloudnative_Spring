package SiG.demo.UserService;

import SiG.demo.Repository.UserRepository;

public class UserModifyServiceImpl implements UserModifyService {

    private final UserRepository userRepository;

    public UserModifyServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void modifyUser(User user) {
        User modifyUser = user;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }
}
