package com.example.demojavaservice.controller;

import com.example.demojavaservice.pojo.HttpResult;
import com.example.demojavaservice.server.IAccountServer;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/user")
public class UserController {
    Logger logger = Logger.getLogger(UserController.class.getName());

    @Resource
    private IAccountServer accountServer;

    @GetMapping("/{resource}")
    public HttpResult hasResource(@PathVariable String resource) {
        logger.info("resid: " + resource);
        return HttpResult.success(accountServer.hasResource(resource));
    }
}

