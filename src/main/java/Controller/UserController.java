package controller;

import dao.DaoManager;
import entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import util.Role;

import java.util.Map;
import java.util.Scanner;

@Component
@RestController
public class UserController {

    private DaoManager DM = new DaoManager();

    @PostMapping(path = "/user", consumes = "application/json")
    @ResponseBody
    public void CreateNewUser(@RequestBody Map<String, Object> body) {
        AddNewUser(body.get("username").toString(), body.get("password").toString());
    }

    @DeleteMapping(path = "/user", consumes = "application/json")
    @ResponseBody
    public void deleteUser(@RequestBody Map<String, Long> body) {

        User u1 = DM.getUserDao().getUser(body.get("userId"));

        DM.getUserDao().deleteUser(u1);
    }

    @GetMapping("/bankAccount")
    public User updateBankAccount(User users){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter an ID");
        long id1 = scan.nextLong();
        User user = DM.getUserDao().getUser(id1);
        System.out.println(user);
        Scanner scanAmount = new Scanner(System.in);
        System.out.println("Enter a quantity");
        int amount1 = scanAmount.nextInt();
        user.setBankAccount(user.getBankAccount() + amount1);
        DM.getUserDao().updateUser(user);
        return user;

    }

//    ------------------------------HELPERS-----------------------------------
    private void AddNewUser(String username, String password)
    {
        User u = new User(username," ", password, Role.Regular, 0);
        DM.getUserDao().createUser(u);
    }
}

