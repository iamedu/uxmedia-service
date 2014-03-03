package com.iamedu.uxmedia.service;

import com.iamedu.uxmedia.data.*;

import com.lambdaworks.crypto.SCryptUtil;

public class UserService {

    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void createUser(String username, String password) {
        String hashed = SCryptUtil.scrypt(password, 16384, 8, 1);

        userDAO.insert(username, hashed);
    }

    public boolean checkPasswowrd(String username, String password) {
        String hashed = userDAO.findPasswordByUsername(username);

        if(password == null) {
            return false;
        }

        return SCryptUtil.check(password, hashed);
    }

}
