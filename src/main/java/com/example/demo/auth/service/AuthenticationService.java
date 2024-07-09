package com.example.demo.auth.service;

import com.example.demo.auth.domain.Account;
import com.example.demo.auth.repository.AccountRepository;
import com.example.demo.auth.usecase.SignUpUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // final, non-null 필드에 대한 생성자
public class AuthenticationService implements SignUpUseCase {

    private final AccountRepository accountRepository;

//    public AuthenticationService(AccountRepository accountRepository) {
//        this.accountRepository = accountRepository;
//    }

    // Ctrl + i
    @Override
    public Account signUp(Account account) {
        return accountRepository.save(account);
    }
}
