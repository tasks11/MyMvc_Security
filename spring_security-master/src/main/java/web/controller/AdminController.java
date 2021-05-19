package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.User;
import web.service.Service;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private Service service;

    @GetMapping
    public String getUsers(ModelMap model) {
        List<User> users = service.getAllUser();
        model.addAttribute("get", users);
        return "get";
    }
}
