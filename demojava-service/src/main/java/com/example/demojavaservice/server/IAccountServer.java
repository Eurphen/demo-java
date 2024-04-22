package com.example.demojavaservice.server;

import com.example.demojavaservice.pojo.NewUser;

public interface IAccountServer {

    boolean addUser(NewUser newUser);

    boolean hasResource(String resource);
}