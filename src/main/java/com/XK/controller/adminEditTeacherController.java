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
public class adminEditTeacherController {

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

    @RequestMapping(path = "/adminEditTeacher")
    public String toAdminEditTeacher(Model model, HttpServletRequest request){
        List<teacherModel> teacherModels = teacherService.getAllTeacher();
        model.addAttribute("teacher", teacherModels);
        if (request.getSession().getAttribute("message") != null){
            String message = request.getSession().getAttribute("message").toString();
            request.setAttribute("message", message);
            request.getSession().setAttribute("message","");
        }
        return "admin/editTeacher";
    }

    @RequestMapping(path = "/adminEditTeacherSave")
    public String editTeacher(HttpServletRequest request){
        String cno = request.getParameter("no");
        String sex = request.getParameter("sex");
        String tel = request.getParameter("tel");
        String departmentname = request.getParameter("academy");
        String degree = request.getParameter("degree");
        String departmentno = departmentService.getDepartmentNo(departmentname);
        if (sex.equals("male")){
            sex = "男";
        }
        else {
            sex = "女";
        }
        if (degree.equals("doctor")){
            degree = "博士";
        }
        else if (degree.equals("master")){
            degree = "硕士";
        }
        else {
            degree = "学士";
        }
        try {
            teacherService.updateTeacherInfo(cno, sex, tel, departmentno, degree);
            request.getSession().setAttribute("message", "更新成功");
        }catch (Exception e){
            request.getSession().setAttribute("message", "更新失败");
        }
        return "redirect: adminEditTeacher";
    }

}
