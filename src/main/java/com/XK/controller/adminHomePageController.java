package com.XK.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class adminHomePageController {

    @RequestMapping(path = "adminHomePage")
    public String toAdminHomePage(){
        return "admin/homePage";
    }

}
