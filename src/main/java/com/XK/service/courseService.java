package com.XK.service;

import com.XK.dao.courseDao;
import com.XK.model.courseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class courseService {

    private courseDao courseDao;
    @Autowired
    public void setCourseDao(courseDao courseDao){
        this.courseDao = courseDao;
    }

    //开课
    public void insertOpenCourse(String courseno, String cno, String coursename, String credit, String departmentno){
        courseModel courseModel = new courseModel();
        courseModel.setCourseno(courseno);
        courseModel.setCno(cno);
        courseModel.setCoursename(coursename);
        courseModel.setCredit(credit);
        courseModel.setDepartmentno(departmentno);
        courseDao.insertOpenCourse(courseModel);
    }

    //关课
    public void deleteCloseCourse(String courseno, String coursename){
        courseModel courseModel = new courseModel();
        courseModel.setCourseno(courseno);
        courseModel.setCoursename(coursename);
        courseDao.deleteCloseCourse(courseModel);
    }

    //查询最大课程号
    public String getMaxCourseno(){
        return courseDao.getMaxCourseno();
    }

    //查询开课教师号码
    public String getCourseCno(String courseno){
        courseModel courseModel = new courseModel();
        courseModel.setCourseno(courseno);
        return courseDao.getCourseCno(courseModel);
    }

    //查询课程名
    public String getCourseCoursename(String courseno){
        courseModel courseModel = new courseModel();
        courseModel.setCourseno(courseno);
        return courseDao.getCourseCoursename(courseModel);
    }

    //查询课程上课信息
    public List<courseModel> getCourseInfo(String courseno){
        courseModel courseModel = new courseModel();
        courseModel.setCourseno(courseno);
        return courseDao.getCourseInfo(courseModel);
    }

    //更新课程教室
    public void updateCourseAddress(String courseno, String weekday, String worktime, String courseaddress){
        courseModel courseModel = new courseModel();
        courseModel.setCourseno(courseno);
        courseModel.setWeekday(weekday);
        courseModel.setWorktime(worktime);
        courseModel.setCourseaddress(courseaddress);
        courseDao.updateCourseAddress(courseModel);
    }

}
