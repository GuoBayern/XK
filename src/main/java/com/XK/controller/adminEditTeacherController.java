package com.XK.controller;

import com.XK.model.teacherModel;
import com.XK.service.teacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class adminEditTeacherController {

    private com.XK.service.teacherService teacherService;
    @Autowired
    public void setTeacherService(teacherService teacherService){
        this.teacherService = teacherService;
    }

    @RequestMapping(path = "/adminEditTeacher")
    public String toAdminEditTeacher(Model model){
        List<teacherModel> teacherModels = teacherService.getAllTeacher();
        model.addAttribute("teacher", teacherModels);
        return "admin/editTeacher";
    }

}
