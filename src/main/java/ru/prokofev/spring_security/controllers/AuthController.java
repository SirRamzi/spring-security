package ru.prokofev.spring_security.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.prokofev.spring_security.models.Account;
import ru.prokofev.spring_security.service.AccountService;
import ru.prokofev.spring_security.util.AccountValidator;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final AccountValidator accountValidator;
    private final AccountService accountService;

    @Autowired
    public AuthController(AccountValidator accountValidator, AccountService accountService) {
        this.accountValidator = accountValidator;
        this.accountService = accountService;
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "auth/login";
    }

    @GetMapping("/registration")
    public String getRegistrationPage(@ModelAttribute("account") Account account) {
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("account") @Valid Account account, BindingResult bindingResult) {
        accountValidator.validate(account, bindingResult);
        if (bindingResult.hasErrors()) {
            return "auth/registration";
        }
        accountService.saveAccount(account);
        return "redirect:/auth/login";
    }
}
