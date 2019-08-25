package com.XK.controller;

import com.XK.model.studentModel;
import com.XK.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class adminEditStudentController {

    private com.XK.service.studentService studentService;
    @Autowired
    public void setStudentService(studentService studentService){
        this.studentService = studentService;
    }

    @RequestMapping(path = "/adminEditStudent")
    public String toAdminEditStudent(Model model, HttpServletRequest request){
        List<studentModel> studentModels = studentService.getAllStudent();
        model.addAttribute("student", studentModels);
        if (request.getSession().getAttribute("editsno") != null){
            String sno = request.getSession().getAttribute("editsno").toString();
            model.addAttribute("editsno", sno);
        }
        request.getSession().setAttribute("editsno", null);
        return "admin/editStudent";
    }

    @RequestMapping(path = "/adminEditStudentEdit")
    public String editStudent(@RequestParam("no") String sno, HttpServletRequest request){
        request.getSession().setAttribute("editsno", sno);
        return "redirect: adminEditStudent";
    }

}
