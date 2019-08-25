package com.XK.controller;

import com.XK.model.studentModel;
import com.XK.service.departmentService;
import com.XK.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class studentHomePageController {

    private studentService studentService;
    @Autowired
    public void setStudentService(studentService studentService){
        this.studentService = studentService;
    }

    private departmentService departmentService;
    @Autowired
    public void setDepartmentService(departmentService departmentService){
        this.departmentService = departmentService;
    }

    @RequestMapping(path = "/studentHomePage")
    public String toStudentHomePage(HttpServletRequest request, Model model){
        String sno = request.getSession().getAttribute("sno").toString();
        List<studentModel> studentModels = studentService.getStudentInfo(sno);
        String deparmentno = studentModels.get(0).getDepartmentno();
        String departmentname = departmentService.getDepartmentName(deparmentno);
        model.addAttribute("studentInfo", studentModels);
        model.addAttribute("departmentname", departmentname);
        return "student/homePage";
    }

}
