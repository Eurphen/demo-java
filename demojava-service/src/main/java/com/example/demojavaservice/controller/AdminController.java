package com.example.demojavaservice.controller;

import com.example.demojavaservice.pojo.HttpResult;
import com.example.demojavaservice.pojo.NewUser;
import com.example.demojavaservice.server.IAccountServer;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/admin")
public class AdminController {
    Logger logger = Logger.getLogger(AdminController.class.getName());

    @Resource
    private IAccountServer accountServer;

    @PostMapping("/addUser")
    public HttpResult addUser(@RequestBody NewUser newUser) {
        logger.info("add user , userid: " + newUser.getUserId());

        boolean loginResult = accountServer.addUser(newUser);
        if (loginResult) {
            return HttpResult.success(newUser.getUserId());
        } else {
            return HttpResult.error(400, "error");
        }

    }
}

