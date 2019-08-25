package com.XK.controller;

import com.XK.model.teacherModel;
import com.XK.service.teacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class adminDeleteTeacherController {

    private teacherService teacherService;
    @Autowired
    public void setTeacherService(teacherService teacherService){
        this.teacherService = teacherService;
    }

    @RequestMapping(path = "/adminDeleteTeacher")
    public String toAdminDeleteTeacher(HttpServletRequest request){
        if (request.getSession().getAttribute("message") != null){
            String message = request.getSession().getAttribute("message").toString();
            request.setAttribute("message", message);
            request.getSession().setAttribute("message","");
        }
        return "admin/deleteTeacher";
    }

    @RequestMapping(path = "/adminDeleteTeacherSave")
    public String deleteTeacherInfo(HttpServletRequest request){
        String cno = request.getParameter("no");
        String cname = request.getParameter("name");
        List<teacherModel> teacherModels = teacherService.getTeacherInfo(cno);
        if (teacherModels.size() == 0){
            request.getSession().setAttribute("message", "工号不存在");
        }
        else {
            String cnamecheck = teacherModels.get(0).getCname();
            if (!cname.equals(cnamecheck)){
                request.getSession().setAttribute("message", "姓名输入错误");
            }
            else {
                try {
                    teacherService.deleteTeacher(cno, cname);
                    request.getSession().setAttribute("message", "删除成功");
                }catch (Exception e){
                    request.getSession().setAttribute("message", "删除失败");
                }
            }
        }
        return "redirect: adminDeleteTeacher";
    }

}
