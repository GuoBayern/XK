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

}
