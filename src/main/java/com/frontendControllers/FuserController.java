package com.frontendControllers;

import com.dao.DaoManager;
import com.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.Enum.Role;

@Controller
@RequestMapping("/user")
public class FuserController {

    private DaoManager DM = new DaoManager();

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getUsersPage() {
        /*Vital thing to contain both: Model and View*/
        ModelAndView modelAndView = new ModelAndView();
        /*data container */
        ModelMap map = new ModelMap();

        /*populating my ModelAndView*/
        modelAndView.addAllObjects(map);
        modelAndView.setViewName("user");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    //Let´s request some info
    public String createNewUser(@RequestParam String username,
                                @RequestParam String email,
                                @RequestParam String password, Model model) {

        //Now let´s create a new user

        User u = AddNewUser(
                username, email, password);

        model.addAttribute("username", username);
        model.addAttribute("email", email);
        model.addAttribute("password", password);


        return "user"; //Aqui deberiamos de retornar algo como "profile"
    }

    private User AddNewUser(String username, String email, String password) {
        User u = new User(username, email, password, Role.Regular, 0);
        DM.getUserDao().createUser(u);
        return u;
    }
}
