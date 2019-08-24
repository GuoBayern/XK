package com.XK.controller;

import com.XK.service.adminService;
import com.XK.service.studentService;
import com.XK.service.teacherService;
import com.XK.utils.PasswordSalt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class indexController {

    private adminService adminService;
    @Autowired
    public void setAdminService(adminService adminService){
        this.adminService = adminService;
    }

    private studentService studentService;
    @Autowired
    public void setStudentService(studentService studentService){
        this.studentService = studentService;
    }

    private teacherService teacherService;
    @Autowired
    public void setTeacherService(teacherService teacherService){
        this.teacherService = teacherService;
    }

    @RequestMapping(path = "/login")
    public String toAdmin(@RequestParam("txtUserName") String no, @RequestParam("txtPassword") String pass, HttpServletRequest request){
        String encPass = PasswordSalt.passSalt(pass);
        String stuPass = studentService.getStudentPass(no);
        String teaPass = teacherService.getTeacherPass(no);
        String adPass = adminService.getAdminPass(no);
        try {
            if (adPass.equals("") && stuPass.equals("") && teaPass.equals("")){
                request.setAttribute("message","用户名不存在！");
                return "../index";
            }
            if (adPass.equals(encPass)){
                request.getSession().setAttribute("adminno", no);
                return "admin/admin";
            }
            else if (stuPass.equals(encPass)){
                request.getSession().setAttribute("sno", no);
                return "admin/admin";
            }
            else if (teaPass.equals(encPass)){
                request.getSession().setAttribute("cno", no);
                return "admin/admin";
            }
            else {
                request.setAttribute("message","用户名或密码错误！");
                return "../index";
            }
        }catch (Exception e){
            request.setAttribute("message","用户名不存在！");
            return "../index";
        }
    }

}
