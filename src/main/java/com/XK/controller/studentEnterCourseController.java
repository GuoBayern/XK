package com.XK.controller;

import com.XK.model.courseModel;
import com.XK.model.departmentModel;
import com.XK.model.teacherModel;
import com.XK.service.courseService;
import com.XK.service.departmentService;
import com.XK.service.scoreService;
import com.XK.service.teacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class studentEnterCourseController {

    private courseService courseService;
    @Autowired
    public void setCourseService(courseService courseService){
        this.courseService = courseService;
    }

    private scoreService scoreService;
    @Autowired
    public void setScoreService(scoreService scoreService){
        this.scoreService = scoreService;
    }

    private teacherService teacherService;
    @Autowired
    public void setTeacherService(teacherService teacherService){
        this.teacherService = teacherService;
    }

    private departmentService departmentService;
    @Autowired
    public void setDepartmentService(departmentService departmentService){
        this.departmentService = departmentService;
    }

    @RequestMapping(path = "/studentEnterCourse")
    public String toStudentEnterCourse(HttpServletRequest request){
        String sno = request.getSession().getAttribute("sno").toString();
        request.getSession().setAttribute("cno", sno);
        if (request.getSession().getAttribute("message") != null){
            String message = request.getSession().getAttribute("message").toString();
            request.setAttribute("message", message);
            request.getSession().setAttribute("message","");
        }
        return "student/enterCourse";
    }

    @RequestMapping(value = "/studentEnterCourseSaveAJAX1", method = {RequestMethod.POST}, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String studentEnterCourseSaveAJAX1(HttpServletRequest request){
        String courseno = request.getParameter("courseno");
        List<courseModel> courseModels = courseService.getAllCourseInfo("%" + courseno + "%");
        List<teacherModel> teacherModels = teacherService.getTeacherNameFromCourse("%" + courseno + "%");
        List<departmentModel> departmentModels = departmentService.getDepartmentNameFromCourse("%" + courseno + "%");
        String result = "";
        for (int i = 0; i < courseModels.size(); i++){
            result = result + "<tr onclick = sub(this)>" + "<td>" + courseModels.get(i).getCourseno() +
                     "<td>" + teacherModels.get(i).getCname() +
                     "<td>" + courseModels.get(i).getCoursename() +
                     "<td>" + courseModels.get(i).getCredit() +
                     "<td>" + departmentModels.get(i).getDepartmentname() +
                     "<td>" + courseModels.get(i).getWeekday() + courseModels.get(i).getWorktime() +
                     "<td>" + courseModels.get(i).getCourseaddress();
        }
        return result;
    }

    @RequestMapping(value = "/studentEnterCourseSaveAJAX2", method = {RequestMethod.POST}, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String studentEnterCourseSaveAJAX2(HttpServletRequest request){
        String coursename = request.getParameter("coursename");
        List<courseModel> courseModels = courseService.getAllCourse("%" + coursename + "%");
        List<teacherModel> teacherModels = teacherService.getTeacherNameFromCourseName("%" + coursename + "%");
        List<departmentModel> departmentModels = departmentService.getDepartmentNameFromCourseName("%" + coursename + "%");
        String result = "";
        for (int i = 0; i < courseModels.size(); i++){
            result = result + "<tr onclick = sub(this)>" + "<td>" + courseModels.get(i).getCourseno() +
                    "<td>" + teacherModels.get(i).getCname() +
                    "<td>" + courseModels.get(i).getCoursename() +
                    "<td>" + courseModels.get(i).getCredit() +
                    "<td>" + departmentModels.get(i).getDepartmentname() +
                    "<td>" + courseModels.get(i).getWeekday() + courseModels.get(i).getWorktime() +
                    "<td>" + courseModels.get(i).getCourseaddress();
        }
        return result;
    }

    @RequestMapping(path = "/studentEnterCourseSave")
    public String saveStudentEnterCourse(HttpServletRequest request){
        String sno = request.getSession().getAttribute("cno").toString();
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
                String coursenoget = scoreService.getScoreCourseno(courseno, sno);
                if (coursenoget != null){
                    request.getSession().setAttribute("message", "已添加该课程");
                }
                else {
                    try {
                        scoreService.insertScoreStudent(courseno, sno);
                        request.getSession().setAttribute("message", "加入成功");
                    }catch (Exception e){
                        request.getSession().setAttribute("message", "加入失败");
                    }
                }
            }
        }
        return "redirect: studentEnterCourse";
    }

}
