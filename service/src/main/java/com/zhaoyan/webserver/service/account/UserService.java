package com.zhaoyan.webserver.service.account;

import com.zhaoyan.webserver.dao.account.UserDao;
import com.zhaoyan.webserver.domain.account.db.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public UserModel getUser(String username, String password) {
        return userDao.getUser(username, password);
    }

    public UserModel getUser(String username) {
        return userDao.getUser(username);
    }

}
