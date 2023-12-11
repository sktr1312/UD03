package clases;

import java.time.LocalDateTime;

public class User {
    // ATRIBUTOS
    private String email, username, password;
    private LocalDateTime createdAt, lastLogin;
    private boolean enabled;

    // constructor
    public User(String email, String username, String password, boolean enabled) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.createdAt = LocalDateTime.now();
    }

    public User(String username, String password) {
        this(null, username, password, true);
    }

    public User(String username){
        this(username, null);
    }

}
