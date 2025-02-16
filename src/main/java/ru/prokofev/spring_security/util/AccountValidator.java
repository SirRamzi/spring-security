package ru.prokofev.spring_security.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.prokofev.spring_security.models.Account;
import ru.prokofev.spring_security.service.AccountService;

@Component
public class AccountValidator implements Validator {

    private final AccountService accountService;

    @Autowired
    public AccountValidator(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Account.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Account account = (Account) target;
        if(accountService.getAccountByUsername(account.getUsername()).isPresent()) {
            errors.rejectValue("username", "", "Указанное имя пользователя занято");
        }
    }
}
