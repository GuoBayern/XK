package com.XK.controller;

import com.XK.service.classroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class adminAddClassroomController {

    private classroomService classroomService;
    @Autowired
    public void setClassroomService(classroomService classroomService){
        this.classroomService = classroomService;
    }

    @RequestMapping(path = "/adminAddClassroom")
    public String toAdminAddClassroom(HttpServletRequest request){
        if (request.getSession().getAttribute("message") != null){
            String message = request.getSession().getAttribute("message").toString();
            request.setAttribute("message", message);
            request.getSession().setAttribute("message","");
        }
        return "admin/addClassroom";
    }

    @RequestMapping(path = "/adminAddClassroomSave")
    public String saveAddClassroom(HttpServletRequest request){
        String courseaddress = request.getParameter("address");
        try {
            classroomService.insertClassroom(courseaddress);
            request.getSession().setAttribute("message", "增加成功");
        }catch (Exception e){
            request.getSession().setAttribute("message", "增加失败");
        }
        return "redirect: adminAddClassroom";
    }

}
