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
    public ModelAndView getUsersPage(){
        /*Vital thing to contain both: Model and View*/
        ModelAndView modelAndView = new ModelAndView();
        /*data container */
        ModelMap map = new ModelMap();
//        map.addAttribute("username", "Pedro");
//        map.addAttribute("email", "pedro@guapo.com");
//        map.addAttribute("password", "piterman20");
        /*populating my ModelAndView*/
        modelAndView.addAllObjects(map);
        modelAndView.setViewName("user");
        return modelAndView;
    }

    @RequestMapping(method= RequestMethod.POST)
    //Aqui vamos a mapear la info de placeholder con el metodo
    public String createNewUser(@RequestParam String username,
                                   @RequestParam String email,
                                   @RequestParam String password, Model model){

        //Ahora que ya lo hemos metido en el placeholder vamos a trasladar
        //lo que hay en el placeholder a que se imprima
        //por eso name es firstname aqui abajo porque el primero
        //era para meter info en el placeholder y este para imprimir
        User u = AddNewUser(
                username, email, password);

        model.addAttribute("username", username);
        model.addAttribute("email", email);
        model.addAttribute("password", password);





        return "user"; //Aqui deberiamos de retornar algo como "profile"
    }

    private User AddNewUser(String username, String email, String password)
    {
        User u = new User(username,email, password, Role.Regular, 0);
        DM.getUserDao().createUser(u);
        return u;
    }
}
