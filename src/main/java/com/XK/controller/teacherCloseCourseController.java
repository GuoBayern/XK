package com.XK.controller;

import com.XK.service.courseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class teacherCloseCourseController {

    private com.XK.service.courseService courseService;
    @Autowired
    public void setCourseService(courseService courseService){
        this.courseService = courseService;
    }

    @RequestMapping(path = "/teacherCloseCourse")
    public String toTeacherCloseCourse(HttpServletRequest request){
        String cno = request.getSession().getAttribute("cno").toString();
        request.getSession().setAttribute("cno", cno);
        if (request.getSession().getAttribute("message") != null){
            String message = request.getSession().getAttribute("message").toString();
            request.setAttribute("message", message);
            request.getSession().setAttribute("message","");
        }
        return "teacher/closeCourse";
    }

    @RequestMapping(path = "/teacherCloseCourseSave")
    public String saveTeacherCloseCourse(HttpServletRequest request){
        String cno = request.getSession().getAttribute("cno").toString();
        String courseno = request.getParameter("no");
        String coursename = request.getParameter("name");
        String cnoget = courseService.getCourseCno(courseno);
        String cousenameget = courseService.getCourseCoursename(courseno);
        if (cnoget == null){
            request.getSession().setAttribute("message", "课程号不存在");
        }
        else {
            if (!cno.equals(cnoget)){
                request.getSession().setAttribute("message", "课程号输入错误");
            }
            else {
                if (!coursename.equals(cousenameget)){
                    request.getSession().setAttribute("message", "课程名输入错误");
                }
                else {
                    try {
                        courseService.deleteCloseCourse(courseno, coursename);
                        request.getSession().setAttribute("message", "关闭成功");
                    }catch (Exception e){
                        request.getSession().setAttribute("message", "关闭失败");
                    }
                }
            }
        }
        return "redirect: teacherCloseCourse";
    }

}
