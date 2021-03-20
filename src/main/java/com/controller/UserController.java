//package com.controller;
//
//import com.dao.DaoManager;
//import com.entity.User;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.*;
//import com.Enum.Role;
//
//import java.com.util.List;
//import java.com.util.Map;
//
//@Component
//@RestController
//public class UserController {
//    //customerController
//    //Deserialize User in Postmapping
//
//    private DaoManager DM = new DaoManager();
//
//    @PostMapping(path = "/user", consumes = "application/json", produces = "application/json")
//    public User CreateNewUser(@RequestBody Map<String, Object> body) {
//        User u = AddNewUser(
//                body.get("username").toString(),
//                body.get("password").toString());
//
//        return u;
//    }
//
//    @PutMapping(path = "/user/{userId}", consumes = "application/json", produces = "application/json")
//    public User UpdateUser(@PathVariable int userId,@RequestBody User user) {
//        User u = DM.getUserDao().getUser(userId);
//        u.setUserAttributes(
//                user.getUsername(),
//                user.getPassword(),
//                user.getEmail(),
//                user.getBankStatement());
//        DM.getUserDao().updateUser(u);
//
//        return u;
//    }
//
//    @DeleteMapping(path = "/user/{userId}", consumes = "application/json", produces = "application/json")
//    public void deleteUser(@PathVariable int userId) {
//
//        User u1 = DM.getUserDao().getUser(userId);
//        DM.getUserDao().deleteUser(u1);
//    }
//
//    @GetMapping(path = "/user/{userId}", consumes = "application/json", produces = "application/json")
//    public User findUser(@PathVariable int userId) {
//        return DM.getUserDao().getUser(userId);
//    }
//
//    @GetMapping(path = "/user/list", consumes = "application/json", produces = "application/json")
//    public List<User> findAllUsers() {
//        return DM.getUserDao().getUser();
//    }
//
//    @GetMapping(path = "/bankAccount/{userId}", consumes = "application/json", produces = "application/json")
//    public int updateBankAccount(@PathVariable int userId){
//        return DM.getUserDao().getUser(userId).getBankStatement();
//    }
//
////    ------------------------------HELPERS-----------------------------------
//    private User AddNewUser(String username, String password)
//    {
//        User u = new User(username," ", password, Role.Regular, 0);
//        DM.getUserDao().createUser(u);
//        return u;
//    }
//}
//
