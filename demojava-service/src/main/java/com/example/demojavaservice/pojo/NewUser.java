package com.example.demojavaservice.pojo;

import java.util.ArrayList;

public class NewUser {
    private int userId;
    private ArrayList<String> endpoint;

    public NewUser() {}

    public NewUser(int userId, ArrayList<String> endpoint) {
        this.userId = userId;
        this.endpoint = endpoint;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public ArrayList<String> getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(ArrayList<String> endpoint) {
        this.endpoint = endpoint;
    }
}
