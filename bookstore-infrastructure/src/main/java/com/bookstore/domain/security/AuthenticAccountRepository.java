package com.bookstore.domain.security;

import com.bookstore.domain.account.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthenticAccountRepository {
    @Autowired
    private AccountServiceClient accountServiceClient;

    public AuthenticAccount findByUsername(String username){
        Account account = accountServiceClient.findByUsername(username);
        return new AuthenticAccount(account);
    }
}
