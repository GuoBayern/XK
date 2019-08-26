package com.XK.controller;

import com.XK.model.teacherModel;
import com.XK.service.courseService;
import com.XK.service.teacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class teacherOpenCourseController {

    private teacherService teacherService;
    @Autowired
    public void setTeacherService(teacherService teacherService){
        this.teacherService = teacherService;
    }

    private courseService courseService;
    @Autowired
    public void setCourseService(courseService courseService){
        this.courseService = courseService;
    }

    @RequestMapping(path = "/teacherOpenCourse")
    public String toTeacherOpenCourse(HttpServletRequest request, Model model){
        String courseno = courseService.getMaxCourseno();
        long coursenolong = Long.parseLong(courseno);
        coursenolong = coursenolong + 1;
        courseno = String.valueOf(coursenolong);
        model.addAttribute("courseno", courseno);
        if (request.getSession().getAttribute("message") != null){
            String message = request.getSession().getAttribute("message").toString();
            request.setAttribute("message", message);
            request.getSession().setAttribute("message","");
        }
        return "teacher/openCourse";
    }

    @RequestMapping(path = "/teacherOpenCourseSave")
    public String saveTeacherOpenCourse(HttpServletRequest request){
        String courseno = request.getParameter("no");
        String cno = request.getSession().getAttribute("cno").toString();
        String coursename = request.getParameter("name");
        String credit = request.getParameter("credit");
        List<teacherModel> teacherModels = teacherService.getTeacherInfo(cno);
        String departmentno = teacherModels.get(0).getDepartmentno();
        try {
            courseService.insertOpenCourse(courseno, cno, coursename, credit, departmentno);
            request.getSession().setAttribute("message", "保存成功");
        }catch (Exception e){
            request.getSession().setAttribute("message", "保存失败");
        }
        return "redirect: teacherOpenCourse";
    }

}
