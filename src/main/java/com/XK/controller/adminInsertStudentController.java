package com.XK.controller;

import com.XK.service.departmentService;
import com.XK.service.studentService;
import com.XK.utils.PasswordSaltDynamic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class adminInsertStudentController {

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

    @RequestMapping(path = "/adminInsertStudent")
    public String toAdminInsertStudent(Model model, HttpServletRequest request){
        String sno = studentService.getMaxStudentSno();
        long snolong = Long.parseLong(sno);
        snolong = snolong + 1;
        sno = String.valueOf(snolong);
        model.addAttribute("sno", sno);
        if (request.getSession().getAttribute("message") != null){
            String message = request.getSession().getAttribute("message").toString();
            request.setAttribute("message", message);
            request.getSession().setAttribute("message","");
        }
        return "admin/insertStudent";
    }

    @RequestMapping(path = "/adminInsertStudentSave")
    public String saveStudentInfo(HttpServletRequest request){
        String sno = request.getParameter("no");
        String sname = request.getParameter("name");
        String rawPass = request.getParameter("pass");
        String sex = request.getParameter("sex");
        String tel = request.getParameter("tel");
        String departmentname = request.getParameter("academy");
        String departmentno = departmentService.getDepartmentNo(departmentname);
        String encPass = PasswordSaltDynamic.enHash(sno, rawPass);
        if (sex.equals("male")){
            sex = "男";
        }
        else {
            sex = "女";
        }
        try {
            studentService.insertStudent(sno, encPass, sname, sex, tel, departmentno);
            request.getSession().setAttribute("message", "保存成功");
        }catch (Exception e){
            request.getSession().setAttribute("message", "保存失败");
        }
        return "redirect: adminInsertStudent";
    }

}
