package com.XK.controller;

import com.XK.model.studentModel;
import com.XK.service.studentService;
import com.XK.utils.PasswordSaltDynamic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class studentEditInfoController {

    private com.XK.service.studentService studentService;
    @Autowired
    public void setStudentService(studentService studentService){
        this.studentService = studentService;
    }

    @RequestMapping(path = "/studentEditInfo")
    public String toStudentEditInfo(HttpServletRequest request, Model model){
        String sno = request.getSession().getAttribute("sno").toString();
        List<studentModel> studentModels = studentService.getStudentInfo(sno);
        model.addAttribute("student", studentModels);
        if (request.getSession().getAttribute("message") != null){
            String message = request.getSession().getAttribute("message").toString();
            request.setAttribute("message", message);
            request.getSession().setAttribute("message","");
        }
        return "student/editInfo";
    }

    @RequestMapping(path = "/studentEditInfoSave")
    public String editStudentInfo(HttpServletRequest request){
        String sno = request.getParameter("no");
        String rawPass = request.getParameter("pass");
        String tel = request.getParameter("tel");
        String encPass = PasswordSaltDynamic.enHash(sno, rawPass);
        try {
            studentService.updateStudentInfoPass(sno, encPass, tel);
            request.getSession().setAttribute("message", "更新成功");
        }catch (Exception e){
            request.getSession().setAttribute("message", "更新失败");
        }
        return "redirect: studentEditInfo";
    }

}
