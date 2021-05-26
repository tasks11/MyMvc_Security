package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.Role;
import web.model.User;
import web.service.Service;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private Service service;

    @GetMapping
    public String getUsers(ModelMap modelMap) {
        List<User> users = service.getAllUser();
        modelMap.addAttribute("all", users);
        return "allUsers";
    }

    @GetMapping("/add")
    public String addGet(ModelMap modelMap) {
        return "addUser";
    }

    @PostMapping("/add")
    public String addPost(@ModelAttribute("user") User user, @RequestParam String role) {
        service.addUser(user, role);
        return "redirect:/admin";
    }

    @GetMapping("/edit/{id}")
    public String getEdit(@ModelAttribute("user") User users, ModelMap modelMap) {
        User user = service.getById(users.getId());
        modelMap.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping("/edit")
    public String postEdit(@ModelAttribute("user") User user, @RequestParam String role) {
        service.editUser(user, role);
        return "redirect:/admin";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@ModelAttribute("user") User users) {
        User user = service.getById(users.getId());
        if (user != null) {
            service.deleteUser(user);
        }
        return "redirect:/admin";
    }

}
