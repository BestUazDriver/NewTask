package com.sabitov.demo.controllers;

import com.sabitov.demo.models.Account;
import com.sabitov.demo.services.AccountService;
import org.hibernate.exception.SQLGrammarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping("/sign_in")
public class SignInController {

    private static final Logger LOGGER = Logger.getLogger(SignInController.class.getName());


    private final AccountService accountService;

    @Autowired
    public SignInController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public String controller() {
        return "sign_in";
    }

    @PostMapping
    public String signIn(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("password") String password) {
        Account account = Account.builder().
                name(name).
                email(email).
                password(password).
                role("user").
                build();
        System.out.println(account);
        try {
            accountService.saveAccount(account);
            LOGGER.log(Level.FINE, "Saved user");
        } catch (SQLGrammarException e) {
            LOGGER.log(Level.WARNING, "Incorrect data");
            throw new IllegalArgumentException(e);
        } catch (IllegalArgumentException e) {
            LOGGER.log(Level.WARNING, "Couldn't save user: Unknown error");
            throw new IllegalArgumentException(e);
        }
        return "main_page";
    }
}
