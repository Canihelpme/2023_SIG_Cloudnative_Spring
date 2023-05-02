package SiG.demo.UserService;

import SiG.demo.Entity.User;

public interface UserService {

    public void addUser(Long id, String userName,
                        String userId, String password);

    public User findUser(Long userId);
}
