package ru.prokofev.spring_security.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.prokofev.spring_security.service.AccountDetailsService;

@EnableWebSecurity
public class SecurityConfig {

    private final AccountDetailsService accountDetailsService;

    @Autowired
    public SecurityConfig(AccountDetailsService accountDetailsService) {
        this.accountDetailsService = accountDetailsService;
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = httpSecurity
                .getSharedObject(AuthenticationManagerBuilder.class);
        httpSecurity.csrf(AbstractHttpConfigurer::disable);
        authenticationManagerBuilder.userDetailsService(accountDetailsService);
        return authenticationManagerBuilder.build();
    }
}