package com.XK.controller;

import com.XK.model.classroomModel;
import com.XK.model.courseModel;
import com.XK.service.classroomService;
import com.XK.service.courseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class adminArrangeCourseController {

    private courseService courseService;
    @Autowired
    public void setCourseService(courseService courseService){
        this.courseService = courseService;
    }

    private classroomService classroomService;
    @Autowired
    public void setClassroomService(classroomService classroomService){
        this.classroomService = classroomService;
    }

    @RequestMapping(path = "/adminArrangeCourse")
    public String toAdminArrangeCourse(HttpServletRequest request, Model model){
        List<classroomModel> classroomModels = classroomService.getClassroomAddress();
        model.addAttribute("classroom", classroomModels);
        if (request.getSession().getAttribute("message") != null){
            String message = request.getSession().getAttribute("message").toString();
            request.setAttribute("message", message);
            request.getSession().setAttribute("message","");
        }
        return "admin/arrangeCourse";
    }

    @RequestMapping(value = "/arrangeCourseAJAX1", method = {RequestMethod.POST})
    @ResponseBody
    public String arrangeCourseAJAX1(HttpServletRequest request){
        String courseno = request.getParameter("courseno");
        String cnoget = courseService.getCourseCno(courseno);
        if (cnoget != null){
            List<courseModel> courseModels = courseService.getCourseInfo(courseno);
            if (courseModels.size() == 1){
                return "Second";
            }
            else {
                return "Arranged";
            }
        }
        else {
            return "Not exist";
        }
    }

    @RequestMapping(path = "/adminArrangeCourseFirst")
    public String arrangeCourseFirst(HttpServletRequest request){
        String courseno = request.getParameter("courseno");
        String cnoget = courseService.getCourseCno(courseno);
        if (cnoget != null){
            List<courseModel> courseModels = courseService.getCourseInfo(courseno);
            if (courseModels.size() == 1){
                request.getSession().setAttribute("courseno", courseno);
                request.getSession().setAttribute("message", "第二步");
            }
            else {
                request.getSession().setAttribute("message", "课程已安排");
            }
        }
        else {
            request.getSession().setAttribute("message", "课程号不存在");
        }
        return "redirect: adminArrangeCourse";
    }

}
