package com.XK.service;

import com.XK.dao.classroomDao;
import com.XK.model.classroomModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class classroomService {

    private classroomDao classroomDao;
    @Autowired
    public void setClassroomDao(classroomDao classroomDao){
        this.classroomDao = classroomDao;
    }

    //增加教室
    public void insertClassroom(String courseaddress){
        classroomModel classroomModel = new classroomModel();
        classroomModel.setCourseaddress(courseaddress);
        classroomDao.insertClassroom(classroomModel);
    }

    //查询教室
    public List<classroomModel> getClassroomAddress(){
        return classroomDao.getClassroomAddress();
    }

    /*获取每个时间段是否有教室*/
    public String getMon1(){
        return classroomDao.getMon1();
    }
    public String getMon2(){
        return classroomDao.getMon2();
    }
    public String getMon3(){
        return classroomDao.getMon3();
    }
    public String getMon4(){
        return classroomDao.getMon4();
    }
    public String getTue1(){
        return classroomDao.getTue1();
    }
    public String getTue2(){
        return classroomDao.getTue2();
    }
    public String getTue3(){
        return classroomDao.getTue3();
    }
    public String getTue4(){
        return classroomDao.getTue4();
    }
    public String getWed1(){
        return classroomDao.getWed1();
    }
    public String getWed2(){
        return classroomDao.getWed2();
    }
    public String getWed3(){
        return classroomDao.getWed3();
    }
    public String getWed4(){
        return classroomDao.getWed4();
    }
    public String getThu1(){
        return classroomDao.getThu1();
    }
    public String getThu2(){
        return classroomDao.getThu2();
    }
    public String getThu3(){
        return classroomDao.getThu3();
    }
    public String getThu4(){
        return classroomDao.getThu4();
    }
    public String getFri1(){
        return classroomDao.getFri1();
    }
    public String getFri2(){
        return classroomDao.getFri2();
    }
    public String getFri3(){
        return classroomDao.getFri3();
    }

}
