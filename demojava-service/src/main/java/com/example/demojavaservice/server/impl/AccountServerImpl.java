package com.example.demojavaservice.server.impl;

import com.example.demojavaservice.pojo.NewUser;
import com.example.demojavaservice.server.IAccountServer;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class AccountServerImpl implements IAccountServer {

    @Resource
    private HttpServletRequest httpServletRequest;

    Logger logger = Logger.getLogger(AccountServerImpl.class.getName());

    private static final String USER_DATA_FILE = "userdata.txt";

    @Override
    public boolean addUser(NewUser newUser) {
        if (!httpServletRequest.getHeader("role").equals("admin")) {
            return false;
        }
        return saveUserToFile(newUser);
    }

    @Override
    public boolean hasResource(String resource) {
        boolean result = false;

        int userId = Integer.parseInt(httpServletRequest.getHeader("userId"));
        List<NewUser> nowUsers = readUsersFromFile();
        for (NewUser user : nowUsers) {
            if (user.getUserId() == userId) {
                result = user.getEndpoint().contains(resource);
            }
        }

        return result;
    }

    private List<NewUser> readUsersFromFile() {
        List<NewUser> users = new ArrayList<>();
        try (
                InputStream inputStream = getClass().getClassLoader().getResourceAsStream(USER_DATA_FILE);
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] userData = line.split(",", 2);
                int id = Integer.parseInt(userData[0]);
                String[] endpointArray = userData[1].split(",");
                ArrayList<String> endpoints = new ArrayList<>();
                for (String endpoint : endpointArray) {
                    endpoints.add(endpoint.trim()); // Trim to remove leading/trailing spaces
                }
                NewUser user = new NewUser(id, endpoints);
                users.add(user);
            }
        } catch (IOException e) {
            logger.warning(e.getMessage());
        }
        return users;
    }

    private boolean saveUserToFile(NewUser user) {
        boolean result = false;
        try (
                OutputStream outputStream = new FileOutputStream(getClass().getClassLoader().getResource(USER_DATA_FILE).getFile());
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream))
        ) {
            StringBuilder endpoints = new StringBuilder();
            for (String endpoint : user.getEndpoint()) {
                endpoints.append(endpoint).append(",");
            }
            if (!endpoints.isEmpty()) {
                endpoints.deleteCharAt(endpoints.length() - 1);
            }
            bw.write(user.getUserId() + "," + endpoints);
            bw.newLine();
            bw.flush();
            result = true;
        } catch (IOException e) {
            logger.warning(e.getMessage());
            result = false;
        }
        return result;
    }
}