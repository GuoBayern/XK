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

    /*查询时间段有空闲的教室*/
    public List<classroomModel> getRestClassroomMon1(){
        return classroomDao.getRestClassroomMon1();
    }
    public List<classroomModel> getRestClassroomMon2(){
        return classroomDao.getRestClassroomMon2();
    }
    public List<classroomModel> getRestClassroomMon3(){
        return classroomDao.getRestClassroomMon3();
    }
    public List<classroomModel> getRestClassroomMon4(){
        return classroomDao.getRestClassroomMon4();
    }
    public List<classroomModel> getRestClassroomTue1(){
        return classroomDao.getRestClassroomTue1();
    }
    public List<classroomModel> getRestClassroomTue2(){
        return classroomDao.getRestClassroomTue2();
    }
    public List<classroomModel> getRestClassroomTue3(){
        return classroomDao.getRestClassroomTue3();
    }
    public List<classroomModel> getRestClassroomTue4(){
        return classroomDao.getRestClassroomTue4();
    }
    public List<classroomModel> getRestClassroomWed1(){
        return classroomDao.getRestClassroomWed1();
    }
    public List<classroomModel> getRestClassroomWed2(){
        return classroomDao.getRestClassroomWed2();
    }
    public List<classroomModel> getRestClassroomWed3(){
        return classroomDao.getRestClassroomWed3();
    }
    public List<classroomModel> getRestClassroomWed4(){
        return classroomDao.getRestClassroomWed4();
    }
    public List<classroomModel> getRestClassroomThu1(){
        return classroomDao.getRestClassroomThu1();
    }
    public List<classroomModel> getRestClassroomThu2(){
        return classroomDao.getRestClassroomThu2();
    }
    public List<classroomModel> getRestClassroomThu3(){
        return classroomDao.getRestClassroomThu3();
    }
    public List<classroomModel> getRestClassroomThu4(){
        return classroomDao.getRestClassroomThu4();
    }
    public List<classroomModel> getRestClassroomFri1(){
        return classroomDao.getRestClassroomFri1();
    }
    public List<classroomModel> getRestClassroomFri2(){
        return classroomDao.getRestClassroomFri2();
    }
    public List<classroomModel> getRestClassroomFri3(){
        return classroomDao.getRestClassroomFri3();
    }

    /*更新教室*/
    public void updateClassroomMon1(String courseaddress){
        classroomModel classroomModel = new classroomModel();
        classroomModel.setCourseaddress(courseaddress);
        classroomDao.updateClassroomMon1(classroomModel);
    }
    public void updateClassroomMon2(String courseaddress){
        classroomModel classroomModel = new classroomModel();
        classroomModel.setCourseaddress(courseaddress);
        classroomDao.updateClassroomMon2(classroomModel);
    }
    public void updateClassroomMon3(String courseaddress){
        classroomModel classroomModel = new classroomModel();
        classroomModel.setCourseaddress(courseaddress);
        classroomDao.updateClassroomMon3(classroomModel);
    }
    public void updateClassroomMon4(String courseaddress){
        classroomModel classroomModel = new classroomModel();
        classroomModel.setCourseaddress(courseaddress);
        classroomDao.updateClassroomMon4(classroomModel);
    }
    public void updateClassroomTue1(String courseaddress){
        classroomModel classroomModel = new classroomModel();
        classroomModel.setCourseaddress(courseaddress);
        classroomDao.updateClassroomTue1(classroomModel);
    }
    public void updateClassroomTue2(String courseaddress){
        classroomModel classroomModel = new classroomModel();
        classroomModel.setCourseaddress(courseaddress);
        classroomDao.updateClassroomTue2(classroomModel);
    }
    public void updateClassroomTue3(String courseaddress){
        classroomModel classroomModel = new classroomModel();
        classroomModel.setCourseaddress(courseaddress);
        classroomDao.updateClassroomTue3(classroomModel);
    }
    public void updateClassroomTue4(String courseaddress){
        classroomModel classroomModel = new classroomModel();
        classroomModel.setCourseaddress(courseaddress);
        classroomDao.updateClassroomTue4(classroomModel);
    }
    public void updateClassroomWed1(String courseaddress){
        classroomModel classroomModel = new classroomModel();
        classroomModel.setCourseaddress(courseaddress);
        classroomDao.updateClassroomWed1(classroomModel);
    }
    public void updateClassroomWed2(String courseaddress){
        classroomModel classroomModel = new classroomModel();
        classroomModel.setCourseaddress(courseaddress);
        classroomDao.updateClassroomWed2(classroomModel);
    }
    public void updateClassroomWed3(String courseaddress){
        classroomModel classroomModel = new classroomModel();
        classroomModel.setCourseaddress(courseaddress);
        classroomDao.updateClassroomWed3(classroomModel);
    }
    public void updateClassroomWed4(String courseaddress){
        classroomModel classroomModel = new classroomModel();
        classroomModel.setCourseaddress(courseaddress);
        classroomDao.updateClassroomWed4(classroomModel);
    }
    public void updateClassroomThu1(String courseaddress){
        classroomModel classroomModel = new classroomModel();
        classroomModel.setCourseaddress(courseaddress);
        classroomDao.updateClassroomThu1(classroomModel);
    }
    public void updateClassroomThu2(String courseaddress){
        classroomModel classroomModel = new classroomModel();
        classroomModel.setCourseaddress(courseaddress);
        classroomDao.updateClassroomThu2(classroomModel);
    }
    public void updateClassroomThu3(String courseaddress){
        classroomModel classroomModel = new classroomModel();
        classroomModel.setCourseaddress(courseaddress);
        classroomDao.updateClassroomThu3(classroomModel);
    }
    public void updateClassroomThu4(String courseaddress){
        classroomModel classroomModel = new classroomModel();
        classroomModel.setCourseaddress(courseaddress);
        classroomDao.updateClassroomThu4(classroomModel);
    }
    public void updateClassroomFri1(String courseaddress){
        classroomModel classroomModel = new classroomModel();
        classroomModel.setCourseaddress(courseaddress);
        classroomDao.updateClassroomFri1(classroomModel);
    }
    public void updateClassroomFri2(String courseaddress){
        classroomModel classroomModel = new classroomModel();
        classroomModel.setCourseaddress(courseaddress);
        classroomDao.updateClassroomFri2(classroomModel);
    }
    public void updateClassroomFri3(String courseaddress){
        classroomModel classroomModel = new classroomModel();
        classroomModel.setCourseaddress(courseaddress);
        classroomDao.updateClassroomFri3(classroomModel);
    }

}
