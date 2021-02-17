package com.main;

import dao.UserDao;
import entity.User;

public class Main {

    public static void main(String[] args) {
        User u = new User("Pedro","Iglesias","Peter@Peterman","Test123");
        UserDao UDao = new UserDao();


        UDao.createUser(u);
    }
}
