package com.example.demo.auth.usecase;

import com.example.demo.auth.domain.Account;

public interface SignUpUseCase {
    Account signUp(Account account);
}
