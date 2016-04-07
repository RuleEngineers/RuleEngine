package com.tw.ruleengine.recommend.controller;

import com.tw.ruleengine.recommend.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@RequestMapping("/login")
@EnableWebMvc
public class LoginController {

    LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {


        this.loginService = loginService;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/enterDetails", method = RequestMethod.POST)
    @ResponseBody
    public void enterDetails(@RequestBody String details) {

        loginService.parseDetails(details);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/validateUser", method = RequestMethod.POST)
    @ResponseBody
    public String validateUser(@RequestBody String details) {

        return loginService.validateLogin(details);
    }
}
