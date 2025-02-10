package ru.prokofev.spring_security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.prokofev.spring_security.models.Account;
import ru.prokofev.spring_security.repository.AccountRepository;
import ru.prokofev.spring_security.security.AccountDetails;

import java.util.Optional;

@Service
public class AccountDetailsService implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountDetailsService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> account = accountRepository.findByUsername(username);
        if (account.isEmpty())
            throw new UsernameNotFoundException("Пользователь с данным именем пользователя не найден");
        return new AccountDetails(account.get());
    }
}
