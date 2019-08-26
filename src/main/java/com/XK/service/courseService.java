package com.XK.service;

import com.XK.dao.courseDao;
import com.XK.model.courseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void deleteCloseCourse(String courseno){
        courseModel courseModel = new courseModel();
        courseModel.setCourseno(courseno);
        courseDao.deleteCloseCourse(courseModel);
    }

    //查询最大课程号
    public String getMaxCourseno(){
        return courseDao.getMaxCourseno();
    }

}
