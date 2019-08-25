package com.XK.controller;

import com.XK.model.studentModel;
import com.XK.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class adminDeleteStudentController {

    private studentService studentService;
    @Autowired
    public void setStudentService(studentService studentService){
        this.studentService = studentService;
    }

    @RequestMapping(path = "/adminDeleteStudent")
    public String toAdminDeleteStudent(HttpServletRequest request){
        if (request.getSession().getAttribute("message") != null){
            String message = request.getSession().getAttribute("message").toString();
            request.setAttribute("message", message);
            request.getSession().setAttribute("message","");
        }
        return "admin/deleteStudent";
    }

    @RequestMapping(path = "/adminDeleteStudentSave")
    public String deleteStudentInfo(HttpServletRequest request){
        String sno = request.getParameter("no");
        String sname = request.getParameter("name");
        List<studentModel> studentModels = studentService.getStudentInfo(sno);
        if (studentModels.size() == 0){
            request.getSession().setAttribute("message", "学号不存在");
        }
        else {
            String snamecheck = studentModels.get(0).getSname();
            if (!sname.equals(snamecheck)){
                request.getSession().setAttribute("message", "姓名输入错误");
            }
            else {
                try {
                    studentService.deleteStudent(sno, sname);
                    request.getSession().setAttribute("message", "删除成功");
                }catch (Exception e){
                    request.getSession().setAttribute("message", "删除失败");
                }
            }
        }
        return "redirect: adminDeleteStudent";
    }

}
