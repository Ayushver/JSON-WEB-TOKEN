package com.example.JWT.controller;

import com.example.JWT.model.User;
import com.example.JWT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private UserService userService;
    @GetMapping("/user")
    public List<User> home(){
        System.out.println("getting users...................");
        return this.userService.getUser();
    }

    @GetMapping("/current-user")
    public String  getLoggedInUser(Principal  principal){
        return principal.getName();
    }
}
