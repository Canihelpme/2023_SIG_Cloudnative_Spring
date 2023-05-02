package SiG.demo.Repository;

import SiG.demo.Entity.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Memory2UserRepository implements UserRepository{

    private static Map<Long, User> store = new ConcurrentHashMap<>();

    public void save(User user) {
        store.put(user.getUserId(), user);
        System.out.println("memory2에서 저장됐습니다.");
    }

    public User find(Long userId) {
        User user = store.get(userId);
        return user;
    }
}
