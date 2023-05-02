package SiG.demo.UserService;

import SiG.demo.EncodeUtil.PasswordEncoder;
import SiG.demo.Entity.User;
import SiG.demo.Repository.UserRepository;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void addUser(Long id, String userName,
                        String userId, String password) {
        String initialEncryptedPassword = passwordEncoder.encryptPassword(password);
        String encryptedPassword = passwordEncoder.encryptPassword(initialEncryptedPassword);

        final User user = User.builder().id(id).userId(userId)
                .userName(userName).password(encryptedPassword).build();
        userRepository.save(user);
    }

    public User findUser(Long userId) {
        return userRepository.find(userId);
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }
}
