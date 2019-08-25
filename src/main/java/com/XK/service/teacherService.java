package com.XK.service;

import com.XK.dao.teacherDao;
import com.XK.model.teacherModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class teacherService {

    private teacherDao teacherDao;
    @Autowired
    public void setTeacherDao(teacherDao teacherDao){
        this.teacherDao = teacherDao;
    }

    //教师登录
    public String getTeacherPass(String cno){
        teacherModel teacherModel = new teacherModel();
        teacherModel.setCno(cno);
        return teacherDao.getTeacherPass(teacherModel);
    }

    //加入教师信息
    public void insertTeacher(String cno, String cpass, String cname, String sex, String tel, String departmentno, String degree){
        teacherModel teacherModel = new teacherModel();
        teacherModel.setCno(cno);
        teacherModel.setCpass(cpass);
        teacherModel.setCname(cname);
        teacherModel.setSex(sex);
        teacherModel.setTel(tel);
        teacherModel.setDepartmentno(departmentno);
        teacherModel.setDegree(degree);
        teacherDao.insertTeacher(teacherModel);
    }

    //获取最大教师编号
    public String getMaxTeacherCno(){
        return teacherDao.getMaxTeacherCno();
    }

}
