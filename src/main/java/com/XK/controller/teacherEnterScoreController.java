package com.XK.controller;

import com.XK.model.courseModel;
import com.XK.model.scoreModel;
import com.XK.model.studentModel;
import com.XK.service.courseService;
import com.XK.service.scoreService;
import com.XK.service.studentService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class teacherEnterScoreController {

    private studentService studentService;
    @Autowired
    public void setStudentService(studentService studentService){
        this.studentService = studentService;
    }

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

    @RequestMapping(path = "/teacherEnterScore")
    public String toTeacherEnterScore(HttpServletRequest request, Model model){
        String cno = request.getSession().getAttribute("cno").toString();
        List<studentModel> studentModels = studentService.getStudentNameFromScore(cno);
        List<scoreModel> scoreModels = scoreService.getTeacherScore(cno);
        List<courseModel> courseModels = courseService.getTeacherScoreCourseName(cno);
        for (int i = 0; i < scoreModels.size(); i++){
            String coursename = courseModels.get(i).getCoursename();
            String sname = studentModels.get(i).getSname();
            studentModels.get(i).setSname(sname);
            studentModels.get(i).setTel(coursename);
            studentModels.get(i).setSno(scoreModels.get(i).getSno());
            studentModels.get(i).setSpass(scoreModels.get(i).getCourseno());
            studentModels.get(i).setDepartmentno(scoreModels.get(i).getScore());
        }
        model.addAttribute("score", studentModels);
        return "teacher/enterScore";
    }

    @RequestMapping(value = "/teacherEnterScoreSave", method = {RequestMethod.POST}, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String saveTeacherEnterScore(HttpServletRequest request){
        String list = request.getParameter("list");
        list = list.substring(1, list.length() - 1);
        JSONObject jsonObj = new JSONObject(list);
        String score = (String)jsonObj.get("score");
        String courseno = (String)jsonObj.get("courseno");
        String sno = (String)jsonObj.get("sno");
        try {
            scoreService.updateScore(score, courseno, sno);
            return "录入成功";
        }catch (Exception e){
            return "录入失败";
        }
    }

}
