package controller;

import dao.DaoManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@ComponentScan("controller")
public class ShoppingController {

    DaoManager DM = new DaoManager();

    public static void main(String[] args) {
        SpringApplication.run(
                ShoppingController.class,
                args
        );
    }

}

