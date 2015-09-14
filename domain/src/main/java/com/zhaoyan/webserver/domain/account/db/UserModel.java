package com.zhaoyan.webserver.domain.account.db;

public class UserModel {
    public int id;
    public String username;
    public String password;
    public int access;

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", access=" + access +
                '}';
    }
}
