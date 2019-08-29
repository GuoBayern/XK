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
        int Mon1 = Integer.parseInt(classroomService.getMon1());
        int Mon2 = Integer.parseInt(classroomService.getMon2());
        int Mon3 = Integer.parseInt(classroomService.getMon3());
        int Mon4 = Integer.parseInt(classroomService.getMon4());
        int Tue1 = Integer.parseInt(classroomService.getTue1());
        int Tue2 = Integer.parseInt(classroomService.getTue2());
        int Tue3 = Integer.parseInt(classroomService.getTue3());
        int Tue4 = Integer.parseInt(classroomService.getTue4());
        int Wed1 = Integer.parseInt(classroomService.getWed1());
        int Wed2 = Integer.parseInt(classroomService.getWed2());
        int Wed3 = Integer.parseInt(classroomService.getWed3());
        int Wed4 = Integer.parseInt(classroomService.getWed4());
        int Thu1 = Integer.parseInt(classroomService.getThu1());
        int Thu2 = Integer.parseInt(classroomService.getThu2());
        int Thu3 = Integer.parseInt(classroomService.getThu3());
        int Thu4 = Integer.parseInt(classroomService.getThu4());
        int Fri1 = Integer.parseInt(classroomService.getFri1());
        int Fri2 = Integer.parseInt(classroomService.getFri2());
        int Fri3 = Integer.parseInt(classroomService.getFri3());
        String result = "";
        if (Mon1 == 0 && Mon2 == 0 && Mon3 == 0 && Mon4 == 0){
            result = result + "1+";
        }
        if (Tue1 == 0 && Tue2 == 0 && Tue3 == 0 && Tue4 == 0){
            result = result + "2+";
        }
        if (Wed1 == 0 && Wed2 == 0 && Wed3 == 0 && Wed4 == 0){
            result = result + "3+";
        }
        if (Thu1 == 0 && Thu2 == 0 && Thu3 == 0 && Thu4 == 0){
            result = result + "4+";
        }
        if (Fri1 == 0 && Fri2 == 0 && Fri3 == 0){
            result = result + "5+";
        }
        if (cnoget != null){
            List<courseModel> courseModels = courseService.getCourseInfo(courseno);
            if (courseModels.size() == 1){
                return result;
            }
            else {
                return "Arranged";
            }
        }
        else {
            return "Not exist";
        }
    }

    @RequestMapping(value = "/arrangeCourseAJAX2", method = {RequestMethod.POST})
    @ResponseBody
    public String arrangeCourseAJAX2(HttpServletRequest request){
        String weekday = request.getParameter("weekday");
        String result = "";
        if (weekday.equals("Mon")){
            int Mon1 = Integer.parseInt(classroomService.getMon1());
            int Mon2 = Integer.parseInt(classroomService.getMon2());
            int Mon3 = Integer.parseInt(classroomService.getMon3());
            int Mon4 = Integer.parseInt(classroomService.getMon4());
            if (Mon1 == 0){
                result = result + "1+";
            }
            if (Mon2 == 0){
                result = result + "2+";
            }
            if (Mon3 == 0){
                result = result + "3+";
            }
            if (Mon4 == 0){
                result = result + "4+";
            }
        }
        if (weekday.equals("Tue")){
            int Tue1 = Integer.parseInt(classroomService.getTue1());
            int Tue2 = Integer.parseInt(classroomService.getTue2());
            int Tue3 = Integer.parseInt(classroomService.getTue3());
            int Tue4 = Integer.parseInt(classroomService.getTue4());
            if (Tue1 == 0){
                result = result + "1+";
            }
            if (Tue2 == 0){
                result = result + "2+";
            }
            if (Tue3 == 0){
                result = result + "3+";
            }
            if (Tue4 == 0){
                result = result + "4+";
            }
        }
        if (weekday.equals("Wed")){
            int Wed1 = Integer.parseInt(classroomService.getWed1());
            int Wed2 = Integer.parseInt(classroomService.getWed2());
            int Wed3 = Integer.parseInt(classroomService.getWed3());
            int Wed4 = Integer.parseInt(classroomService.getWed4());
            if (Wed1 == 0){
                result = result + "1+";
            }
            if (Wed2 == 0){
                result = result + "2+";
            }
            if (Wed3 == 0){
                result = result + "3+";
            }
            if (Wed4 == 0){
                result = result + "4+";
            }
        }
        if (weekday.equals("Thu")){
            int Thu1 = Integer.parseInt(classroomService.getThu1());
            int Thu2 = Integer.parseInt(classroomService.getThu2());
            int Thu3 = Integer.parseInt(classroomService.getThu3());
            int Thu4 = Integer.parseInt(classroomService.getThu4());
            if (Thu1 == 0){
                result = result + "1+";
            }
            if (Thu2 == 0){
                result = result + "2+";
            }
            if (Thu3 == 0){
                result = result + "3+";
            }
            if (Thu4 == 0){
                result = result + "4+";
            }
        }
        if (weekday.equals("Fri")){
            int Fri1 = Integer.parseInt(classroomService.getFri1());
            int Fri2 = Integer.parseInt(classroomService.getFri2());
            int Fri3 = Integer.parseInt(classroomService.getFri3());
            if (Fri1 == 0){
                result = result + "1+";
            }
            if (Fri2 == 0){
                result = result + "2+";
            }
            if (Fri3 == 0){
                result = result + "3+";
            }
        }
        return result;
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
