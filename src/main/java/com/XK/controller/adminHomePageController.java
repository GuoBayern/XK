package com.XK.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class adminHomePageController {

    @RequestMapping(path = "adminHomePage")
    public String toAdminHomePage(HttpServletRequest request){
        String cno = request.getSession().getAttribute("cno").toString();
        request.getSession().setAttribute("cno", cno);
        return "admin/homePage";
    }

}
