package com.XK.controller;

import com.XK.model.courseModel;
import com.XK.service.courseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class studentMyCourseController {

    private courseService courseService;
    @Autowired
    public void setCourseService(courseService courseService){
        this.courseService = courseService;
    }

    @RequestMapping(path = "/studentMyCourse")
    public String toStudentMyCourse(HttpServletRequest request, Model model){
        String sno = request.getSession().getAttribute("sno").toString();
        List<courseModel> courseModels = courseService.getStudentCourse(sno);
        for (courseModel courseModel : courseModels) {
            if (courseModel.getWeekday() != null) {
                String coursename = courseModel.getCoursename();
                String weekday = courseModel.getWeekday();
                String worktime = courseModel.getWorktime();
                String courseaddress = courseModel.getCourseaddress();
                switch (weekday) {
                    case "星期一":
                        weekday = "1";
                        break;
                    case "星期二":
                        weekday = "2";
                        break;
                    case "星期三":
                        weekday = "3";
                        break;
                    case "星期四":
                        weekday = "4";
                        break;
                    case "星期五":
                        weekday = "5";
                        break;
                }
                switch (worktime) {
                    case "1(8:00-9:40)":
                        worktime = "1";
                        break;
                    case "2(10:00-11:40)":
                        worktime = "2";
                        break;
                    case "3(13:00-14:40)":
                        worktime = "3";
                        break;
                    case "4(15:00-16:40)":
                        worktime = "4";
                        break;
                }
                String weekdayworktime = weekday + worktime;
                String coursenameaddress = coursename + "   " + courseaddress;
                switch (weekdayworktime) {
                    case "11":
                        model.addAttribute("oneone", coursenameaddress);
                        break;
                    case "12":
                        model.addAttribute("onetwo", coursenameaddress);
                        break;
                    case "13":
                        model.addAttribute("onethree", coursenameaddress);
                        break;
                    case "14":
                        model.addAttribute("onefour", coursenameaddress);
                        break;
                    case "21":
                        model.addAttribute("twoone", coursenameaddress);
                        break;
                    case "22":
                        model.addAttribute("twotwo", coursenameaddress);
                        break;
                    case "23":
                        model.addAttribute("twothree", coursenameaddress);
                        break;
                    case "24":
                        model.addAttribute("twofour", coursenameaddress);
                        break;
                    case "31":
                        model.addAttribute("threeone", coursenameaddress);
                        break;
                    case "32":
                        model.addAttribute("threetwo", coursenameaddress);
                        break;
                    case "33":
                        model.addAttribute("threethree", coursenameaddress);
                        break;
                    case "34":
                        model.addAttribute("threefour", coursenameaddress);
                        break;
                    case "41":
                        model.addAttribute("fourone", coursenameaddress);
                        break;
                    case "42":
                        model.addAttribute("fourtwo", coursenameaddress);
                        break;
                    case "43":
                        model.addAttribute("fourthree", coursenameaddress);
                        break;
                    case "44":
                        model.addAttribute("fourfour", coursenameaddress);
                        break;
                    case "51":
                        model.addAttribute("fiveone", coursenameaddress);
                        break;
                    case "52":
                        model.addAttribute("fivetwo", coursenameaddress);
                        break;
                    case "53":
                        model.addAttribute("fivethree", coursenameaddress);
                        break;
                }
            }
        }
        return "student/myCourse";
    }

}
