package com.XK.controller;

import com.XK.service.departmentService;
import com.XK.service.teacherService;
import com.XK.utils.PasswordSaltDynamic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class adminInsertTeacherController {

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

    @RequestMapping(path = "/adminInsertTeacher")
    public String toAdminInsertTeacher(Model model, HttpServletRequest request){
        String cno = teacherService.getMaxTeacherCno();
        long cnolong = Long.parseLong(cno);
        cnolong = cnolong + 1;
        cno = String.valueOf(cnolong);
        model.addAttribute("cno", cno);
        if (request.getSession().getAttribute("message") != null){
            String message = request.getSession().getAttribute("message").toString();
            request.setAttribute("message", message);
            request.getSession().setAttribute("message","");
        }
        return "admin/insertTeacher";
    }

    @RequestMapping(path = "/adminInsertTeacherSave")
    public String saveTeacherInfo(HttpServletRequest request){
        String cno = request.getParameter("no");
        String cname = request.getParameter("name");
        String rawPass = request.getParameter("pass");
        String sex = request.getParameter("sex");
        String tel = request.getParameter("tel");
        String departmentname = request.getParameter("academy");
        String degree = request.getParameter("degree");
        String departmentno = departmentService.getDepartmentNo(departmentname);
        String encPass = PasswordSaltDynamic.enHash(cno, rawPass);
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
            teacherService.insertTeacher(cno, encPass, cname, sex, tel, departmentno, degree);
            request.getSession().setAttribute("message", "保存成功");
        }catch (Exception e){
            request.getSession().setAttribute("message", "保存失败");
        }
        return "redirect: adminInsertTeacher";
    }

}
