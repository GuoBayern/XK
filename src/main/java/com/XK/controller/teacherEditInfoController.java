package com.XK.controller;

import com.XK.model.teacherModel;
import com.XK.service.teacherService;
import com.XK.utils.PasswordSaltDynamic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class teacherEditInfoController {

    private teacherService teacherService;
    @Autowired
    public void setTeacherService(teacherService teacherService){
        this.teacherService = teacherService;
    }

    @RequestMapping(path = "/teacherEditInfo")
    public String toTeacherEditInfo(HttpServletRequest request, Model model){
        String cno = request.getSession().getAttribute("cno").toString();
        List<teacherModel> teacherModels = teacherService.getTeacherInfo(cno);
        model.addAttribute("teacher", teacherModels);
        if (request.getSession().getAttribute("message") != null){
            String message = request.getSession().getAttribute("message").toString();
            request.setAttribute("message", message);
            request.getSession().setAttribute("message","");
        }
        return "teacher/editInfo";
    }

    @RequestMapping(path = "/teacherEditInfoSave")
    public String editTeacherInfo(HttpServletRequest request){
        String cno = request.getParameter("no");
        String rawPass = request.getParameter("pass");
        String tel = request.getParameter("tel");
        String encPass = PasswordSaltDynamic.enHash(cno, rawPass);
        try {
            teacherService.updateTeacherInfoPass(cno, encPass, tel);
            request.getSession().setAttribute("message", "更新成功");
        }catch (Exception e){
            request.getSession().setAttribute("message", "更新失败");
        }
        return "redirect: teacherEditInfo";
    }

}
