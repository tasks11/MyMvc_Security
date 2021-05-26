package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.model.User;
import web.service.Service;

import javax.annotation.PostConstruct;

@Controller
public class UserController {

    @Autowired
    Service service;

    @GetMapping("/user")
    public String getUser(ModelMap model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("users", user);
        return "user";
    }

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostConstruct
    public void init() {
        service.init();
    }
}
