package SiG.demo.Repository;

import SiG.demo.UserService.User;

public interface UserRepository {

    public void save(User user);

    public User find(Long userId);
}
