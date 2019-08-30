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
public class studentMyCreditController {

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

    @RequestMapping(path = "/studentMyCredit")
    public String toStudentMyCredit(HttpServletRequest request, Model model){
        String sno = request.getSession().getAttribute("sno").toString();
        List<scoreModel> scoreModels = scoreService.getStudentScore(sno);
        List<courseModel> courseModels = courseService.getStudentCreditCourseName(sno);
        int result = 0;
        for (int i = 0; i < scoreModels.size(); i++){
            String coursename = courseModels.get(i).getCoursename();
            String credit = courseModels.get(i).getCredit();
            String score = scoreModels.get(i).getScore();
            if (scoreModels.get(i).getScore() == null){
                credit = "0/" + credit;
            }
            else {
                if (Integer.parseInt(score) < 60){
                    credit = "0/" + credit;
                }
                else {
                    result = result + Integer.parseInt(credit);
                    credit = credit + "/" + credit;
                }
            }
            scoreModels.get(i).setCourseno(coursename);
            scoreModels.get(i).setScore(credit);
        }
        String totalcredit = String.valueOf(result) + "/42";
        model.addAttribute("score", scoreModels);
        model.addAttribute("result", totalcredit);
        return "student/myCredit";
    }

}
