package com.XK.controller;

import com.XK.service.adminService;
import com.XK.service.studentService;
import com.XK.service.teacherService;
import com.XK.utils.PasswordSalt;
import com.XK.utils.PasswordSaltDynamic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @RequestMapping(path = "/index")
    public String toIndex(){
        return "../index";
    }

    @RequestMapping(path = "/login")
    public String toAdmin(@RequestParam("txtUserName") String no, @RequestParam("txtPassword") String pass, HttpServletRequest request){
        if (isNumeric(no)){
            String encPassDynamic = PasswordSaltDynamic.enHash(no, pass);
            String nosub = no.substring(0,5);
            if (nosub.equals("19090")){
                try {
                    String stuPass = studentService.getStudentPass(no);
                    if (stuPass.equals("")){
                        request.setAttribute("message","用户名不存在！");
                        return "../index";
                    }
                    if (stuPass.equals(encPassDynamic)){
                        request.getSession().setAttribute("sno", no);
                        return "redirect: studentHomePage";
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
            else if (nosub.equals("10280")){
                try {
                    String teaPass = teacherService.getTeacherPass(no);
                    if (teaPass.equals("")){
                        request.setAttribute("message","用户名不存在！");
                        return "../index";
                    }
                    if (teaPass.equals(encPassDynamic)){
                        request.getSession().setAttribute("cno", no);
                        return "redirect: adminHomePage";
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
            else {
                request.setAttribute("message","用户名不存在！");
                return "../index";
            }
        }
        else {
            String encPass = PasswordSalt.passSalt(pass);
            try {
                String adPass = adminService.getAdminPass(no);
                if (adPass.equals("")){
                    request.setAttribute("message","用户名不存在！");
                    return "../index";
                }
                if (adPass.equals(encPass)){
                    request.getSession().setAttribute("ano", no);
                    return "redirect: adminHomePage";
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

    //判断传入的用户名是否为纯数字
    private static boolean isNumeric(String string){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

}
