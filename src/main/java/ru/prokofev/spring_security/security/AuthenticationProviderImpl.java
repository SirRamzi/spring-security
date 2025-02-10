package ru.prokofev.spring_security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import ru.prokofev.spring_security.service.AccountDetailsService;

import java.util.Collections;

@Component
public class AuthenticationProviderImpl implements AuthenticationProvider {

    private final AccountDetailsService accountDetailsService;

    @Autowired
    public AuthenticationProviderImpl(AccountDetailsService accountDetailsService) {
        this.accountDetailsService = accountDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        UserDetails accountDetails = accountDetailsService.loadUserByUsername(username);
        String password = authentication.getCredentials().toString();
        if (!password.equals(accountDetails.getPassword()))
            throw new BadCredentialsException("Неверный пароль");
        return new UsernamePasswordAuthenticationToken(accountDetails, password, Collections.emptyList());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
