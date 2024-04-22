package com.example.demojavaservice;

import org.springframework.stereotype.Service;

@Service
public class AccountServerImpl implements IAccountServer {

    @Override
    public User login(LoginReq loginReq) {
        return new User();
    }
}