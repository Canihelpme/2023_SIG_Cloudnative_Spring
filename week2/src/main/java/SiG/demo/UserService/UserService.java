package SiG.demo.UserService;

public interface UserService {

    public void addUser(Long id, String userName,
                        String userId, String password);

    public User findUser(Long userId);
}
