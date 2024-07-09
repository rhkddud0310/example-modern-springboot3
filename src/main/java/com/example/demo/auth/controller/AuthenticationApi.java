package com.example.demo.auth.controller;

import com.example.demo.auth.controller.dto.AuthenticationDto.SignUpRequest;
import com.example.demo.auth.domain.Account;
import com.example.demo.auth.domain.AccountStatus;
import com.example.demo.auth.usecase.SignUpUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequiredArgsConstructor
public class AuthenticationApi {
    // Field
    private final SignUpUseCase signUpUseCase;

    @PostMapping("/sign-up")
    public void signUp(@RequestBody @Valid SignUpRequest body) {
        Account account = Account.builder()
                .username(body.username())
                .nickname(body.nickname())
                .password(body.password())
                .status(AccountStatus.ACTIVE)
                .createdAt(Instant.now())
                .build();

        signUpUseCase.signUp(account);
    }
}
