package SiG.demo.Repository;

import SiG.demo.UserService.User;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MemoryUserRepository implements UserRepository {

    private static Map<Long, User> store = new ConcurrentHashMap<>();

    public void save(User user) {
        store.put(user.getUserId(), user);
        System.out.println("memory1에서 저장되었습니다.");
    }

    public User find(Long userId) {
        User user = store.get(userId);
        return user;
    }
}