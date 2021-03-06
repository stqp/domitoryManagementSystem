package jp.co.dms.infrastructure.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityController.class);

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

//    @GetMapping(value = "/public")
//    public String publicApi() {
//        return "this is public";
//    }
//
//    @GetMapping(value = "/private")
//    public String privateApi() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String username = (String) (authentication.getPrincipal());
//        return "this is private for " + username;
//    }

//    @PostMapping(value = SecurityConstants.LOGIN_URL)
//    public void signup(@Valid @RequestBody UserForm user) {
//        user.encrypt(bCryptPasswordEncoder);
//        LOGGER.info("signup :" + user.toString());
//    }

}
