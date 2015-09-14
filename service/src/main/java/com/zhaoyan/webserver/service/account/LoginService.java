package com.zhaoyan.webserver.service.account;

import com.zhaoyan.webserver.dao.account.UserDao;
import com.zhaoyan.webserver.domain.account.db.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserDao userDao;

    public boolean login(String username, String password) {
        UserModel userModel = userDao.getUser(username, password);
        return userModel != null;
    }

}
