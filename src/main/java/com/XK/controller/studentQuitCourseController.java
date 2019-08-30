package com.XK.controller;

import com.XK.service.courseService;
import com.XK.service.scoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class studentQuitCourseController {

    courseService courseService;
    @Autowired
    public void setCourseService(courseService courseService){
        this.courseService = courseService;
    }

    scoreService scoreService;
    @Autowired
    public void setScoreService(scoreService scoreService){
        this.scoreService = scoreService;
    }

    @RequestMapping(path = "/studentQuitCourse")
    public String toStudentQuitCourse(HttpServletRequest request){
        String sno = request.getSession().getAttribute("sno").toString();
        request.getSession().setAttribute("sno", sno);
        if (request.getSession().getAttribute("message") != null){
            String message = request.getSession().getAttribute("message").toString();
            request.setAttribute("message", message);
            request.getSession().setAttribute("message","");
        }
        return "student/quitCourse";
    }

    @RequestMapping(path = "/studentQuitCourseSave")
    public String saveStudentQuitCourse(HttpServletRequest request){
        String sno = request.getSession().getAttribute("sno").toString();
        String courseno = request.getParameter("no");
        String coursename = request.getParameter("name");
        String cnoget = courseService.getCourseCno(courseno);
        String coursenameget = courseService.getCourseCoursename(courseno);
        if (cnoget == null){
            request.getSession().setAttribute("message", "课程号不存在");
        }
        else {
            if (!coursename.equals(coursenameget)){
                request.getSession().setAttribute("message", "课程名输入错误");
            }
            else {
                String coursenoget = scoreService.getCourseNo(courseno, sno);
                if (coursenoget == null){
                    request.getSession().setAttribute("message", "尚未添加该课程");
                }
                else {
                    try {
                        scoreService.deleteScore(courseno, sno);
                        request.getSession().setAttribute("message", "退出成功");
                    }catch (Exception e){
                        request.getSession().setAttribute("message", "退出失败");
                    }
                }
            }
        }
        return "redirect: studentQuitCourse";
    }

}
