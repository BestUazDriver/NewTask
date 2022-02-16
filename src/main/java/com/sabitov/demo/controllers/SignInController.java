package com.sabitov.demo.controllers;

import com.sabitov.demo.account_dto.CreateUserDto;
import com.sabitov.demo.account_dto.SimpleUserDto;
import com.sabitov.demo.models.Account;
import com.sabitov.demo.services.AccountService;
import org.hibernate.exception.SQLGrammarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sign_in")
public class SignInController {

    private static final Logger LOGGER = Logger.getLogger(SignInController.class.getName());


    private final AccountService accountService;

    @Autowired
    public SignInController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public Iterable<SimpleUserDto> controller() {
        return accountService.findAll().stream().map(SimpleUserDto::reverseForm).collect(Collectors.toList());
    }

    @PostMapping
    public SimpleUserDto signIn(@Valid @RequestBody CreateUserDto dto) {
        Account account = Account.builder().
                name(dto.getName()).
                email(dto.getEmail()).
                password(dto.getPassword()).
                role("user").
                build();
        return accountService.saveDto(account);
    }
}
