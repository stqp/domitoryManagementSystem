package jp.co.dms.infrastructure.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import static jp.co.dms.infrastructure.security.SecurityConstants.LOGIN_URL;
import static jp.co.dms.infrastructure.security.SecurityConstants.SIGNUP_URL;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Qualifier("simpleUserDetailsService")
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and().authorizeRequests()
                .antMatchers("/public", SIGNUP_URL, LOGIN_URL).permitAll()
                .anyRequest().authenticated()
                .and()
                .cors().configurationSource(this.corsConfigurationSource())
                .and().logout()
                .and().csrf().disable()
                .addFilter(new JWTAuthenticationFilter(authenticationManager(), bCryptPasswordEncoder()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }


    private CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedHeader(CorsConfiguration.ALL);
        corsConfiguration.addAllowedMethod(CorsConfiguration.ALL);
        corsConfiguration.addAllowedOrigin("http://localhost:8080");
        corsConfiguration.addAllowedOrigin("http://localhost:9999");
        corsConfiguration.setAllowCredentials(true);

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }

    @Autowired
    public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(bCryptPasswordEncoder());
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


}