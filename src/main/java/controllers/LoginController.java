package controllers;


import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.user.IUserService;

import java.util.List;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    IUserService userService;

    @GetMapping("login")
    public ModelAndView showFormLogin(){
        return new ModelAndView("loginForm","user",new User());
    }

    @PostMapping("login")
    public ModelAndView login(@ModelAttribute User user){
        ModelAndView modelAndView = new ModelAndView("loginForm");
        List<User> userList = userService.findAll();
        for (User u : userList){
            if (u.getAccount().equals(user.getAccount())&&u.getPassword().equals(user.getPassword())){
                return new ModelAndView("userInfo","user",u);
            }
        }

        modelAndView.addObject("message","Login Fail");
        modelAndView.addObject("user",new User());

        return modelAndView;
    }
}
