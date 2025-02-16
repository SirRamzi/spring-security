package ru.prokofev.spring_security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.prokofev.spring_security.models.Account;

import java.util.Collection;

public class AccountDetails implements UserDetails {

    private final Account account;

    @Autowired
    public AccountDetails(Account account) {
        this.account = account;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return "{noop}" + this.account.getPassword();
    }

    @Override
    public String getUsername() {
        return this.account.getUsername();
    }

    public Account getAccount() {
        return account;
    }
}
