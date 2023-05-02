package SiG.demo.Entity;

import lombok.Builder;

@Builder
public class User {

    private Long id;

    private String userName;

    private String userId;

    private String password;

    public User(Long id, String userName,
                String userId, String password) {

        this.id = id;
        this.userName =  userName;
        this.userId = userId;
        this.password = password;

    }

    public Long getUserId() {
        return id;
    }

    public String getUserName() { return userName; }

    public String getPassword() {
        return password;
    }

}
