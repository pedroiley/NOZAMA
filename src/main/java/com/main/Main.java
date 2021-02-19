package com.main;

import dao.UserDao;
import entity.User;
import util.Role;

public class Main {

    public static void main(String[] args) {
        User u = new User("Pedro","Iglesias","Fake@Email","Test@123", Role.Admin);
        UserDao UDao = new UserDao();


        UDao.createUser(u);
    }
}
