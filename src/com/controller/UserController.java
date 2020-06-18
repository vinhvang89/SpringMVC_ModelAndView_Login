package com.controller;

import com.dao.UserDAO;
import com.model.Login;
import com.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @GetMapping("/home")
    public ModelAndView home(){
        return new ModelAndView("home","login",new Login());
    }
    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("login") Login login){
        User user = UserDAO.checkLogin(login);
        if(user == null){
            return new ModelAndView("error");
        } else {
            ModelAndView modelAndView = new ModelAndView("user");
            modelAndView.addObject(user);
            return modelAndView;
        }
    }

}

