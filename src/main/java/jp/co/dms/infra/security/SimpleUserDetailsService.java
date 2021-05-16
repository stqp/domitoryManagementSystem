package jp.co.dms.infra.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SimpleUserDetailsService implements UserDetailsService {

    private static List<String> usernameList = Arrays.asList("user01", "admin01");
    private static String ENCRYPTED_PASSWORD = "$2a$10$5DF/j5hHnbeHyh85/0Bdzu1HV1KyJKZRt2GhpsfzQ8387A/9duSuq";
    private static String password = "password";

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (!usernameList.contains(username)) {
            throw new UsernameNotFoundException(username);
        }

        return User
                .withUsername(username)
                .password(ENCRYPTED_PASSWORD)
                .authorities("ROLE_USER")
                .build();
    }

}