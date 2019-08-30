package com.XK.service;

import com.XK.dao.scoreDao;
import com.XK.model.courseModel;
import com.XK.model.scoreModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class scoreService {

    private scoreDao scoreDao;
    @Autowired
    public void setScoreDao(scoreDao scoreDao){
        this.scoreDao = scoreDao;
    }

    //查询学生是否加入该课程
    public String getScoreCourseno(String courseno, String sno){
        scoreModel scoreModel = new scoreModel();
        scoreModel.setCourseno(courseno);
        scoreModel.setSno(sno);
        return scoreDao.getScoreCourseno(scoreModel);
    }

    //学生加入课程
    public void insertScoreStudent(String courseno, String sno){
        scoreModel scoreModel = new scoreModel();
        scoreModel.setCourseno(courseno);
        scoreModel.setSno(sno);
        scoreDao.insertScoreStudent(scoreModel);
    }

    //学生是否已加入课程
    public String getCourseNo(String courseno, String sno){
        scoreModel scoreModel = new scoreModel();
        scoreModel.setCourseno(courseno);
        scoreModel.setSno(sno);
        return scoreDao.getScoreCourseNo(scoreModel);
    }

    //学生退出课程
    public void deleteScore(String courseno, String sno){
        scoreModel scoreModel = new scoreModel();
        scoreModel.setCourseno(courseno);
        scoreModel.setSno(sno);
        scoreDao.deleteScore(scoreModel);
    }

    //学生查询成绩
    public List<scoreModel> getStudentScore(String sno){
        scoreModel scoreModel = new scoreModel();
        scoreModel.setSno(sno);
        return scoreDao.getStudentScore(scoreModel);
    }

    //教师查询成绩
    public List<scoreModel> getTeacherScore(String cno){
        courseModel courseModel = new courseModel();
        courseModel.setCno(cno);
        return scoreDao.getTeacherScore(courseModel);
    }

    //教师录入成绩
    public void updateScore(String score, String courseno, String sno){
        scoreModel scoreModel = new scoreModel();
        scoreModel.setScore(score);
        scoreModel.setCourseno(courseno);
        scoreModel.setSno(sno);
        scoreDao.updateScore(scoreModel);
    }

}
