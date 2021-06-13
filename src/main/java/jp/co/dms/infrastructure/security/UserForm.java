package jp.co.dms.infrastructure.security;

import org.springframework.security.crypto.password.PasswordEncoder;

public class UserForm {

    private String email;

    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void encrypt(PasswordEncoder encoder) {
        this.password = encoder.encode(password);
    }

    @Override
    public String toString() {
        return "UserForm{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
