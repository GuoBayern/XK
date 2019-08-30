package com.XK.controller;

import com.XK.model.courseModel;
import com.XK.model.scoreModel;
import com.XK.service.courseService;
import com.XK.service.scoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class studentMyScoreController {

    private scoreService scoreService;
    @Autowired
    public void setScoreService(scoreService scoreService){
        this.scoreService = scoreService;
    }

    private courseService courseService;
    @Autowired
    public void setCourseService(courseService courseService){
        this.courseService = courseService;
    }

    @RequestMapping(path = "/studentMyScore")
    public String toStudentMyCourse(HttpServletRequest request, Model model){
        String sno = request.getSession().getAttribute("sno").toString();
        List<scoreModel> scoreModels = scoreService.getStudentScore(sno);
        List<courseModel> courseModels = courseService.getStudentScoreCourseName(sno);
        for (int i = 0; i < scoreModels.size(); i++){
            String coursename = courseModels.get(i).getCoursename();
            scoreModels.get(i).setCourseno(coursename);
            if (scoreModels.get(i).getScore() == null){
                scoreModels.get(i).setScore("未出");
            }
        }
        model.addAttribute("score", scoreModels);
        return "student/myScore";
    }

}
