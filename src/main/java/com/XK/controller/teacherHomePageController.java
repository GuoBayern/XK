package com.XK.controller;

import com.XK.model.teacherModel;
import com.XK.service.departmentService;
import com.XK.service.teacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class teacherHomePageController {

    private teacherService teacherService;
    @Autowired
    public void setTeacherService(teacherService teacherService){
        this.teacherService = teacherService;
    }

    private com.XK.service.departmentService departmentService;
    @Autowired
    public void setDepartmentService(departmentService departmentService){
        this.departmentService = departmentService;
    }

    @RequestMapping(path = "/teacherHomePage")
    public String toTeacherHomePage(HttpServletRequest request, Model model){
        String cno = request.getSession().getAttribute("cno").toString();
        List<teacherModel> teacherModels = teacherService.getTeacherInfo(cno);
        String departmentno = teacherModels.get(0).getDepartmentno();
        String departmentname = departmentService.getDepartmentName(departmentno);
        model.addAttribute("teacherInfo", teacherModels);
        model.addAttribute("departmentname", departmentname);
        return "teacher/homePage";
    }

}
