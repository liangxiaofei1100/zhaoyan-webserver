package com.zhaoyan.webserver.dao.account;

import com.zhaoyan.webserver.domain.account.db.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDao {
    Logger logger = LoggerFactory.getLogger(UserDao.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserModel getUser(String username, String password) {
        String sql = "SELECT * FROM user WHERE username=? AND password=?";
        Object[] params = new Object[]{username, password};
        final UserModel userModel = new UserModel();
        jdbcTemplate.query(sql, params, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                userModel.id = resultSet.getInt("userid");
                userModel.username = resultSet.getString("username");
                userModel.password = resultSet.getString("password");
                userModel.access = resultSet.getInt("access");
            }
        });

        if (userModel.username != null) {
            return userModel;
        } else {
            return null;
        }
    }

    public UserModel getUser(String username) {
        String sql = "SELECT * FROM user WHERE username=?";
        Object[] params = new Object[]{username};
        final UserModel userModel = new UserModel();
        jdbcTemplate.query(sql, params, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                userModel.id = resultSet.getInt("userid");
                userModel.username = resultSet.getString("username");
                userModel.password = resultSet.getString("password");
                userModel.access = resultSet.getInt("access");
            }
        });

        if (userModel.username != null) {
            return userModel;
        } else {
            return null;
        }
    }
}
