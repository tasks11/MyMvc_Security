package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import web.service.Service;

import javax.annotation.PostConstruct;

@Controller
public class RegistrationController {

   @Autowired
   Service service;

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostConstruct
    public void init() {
        service.init();
    }
}