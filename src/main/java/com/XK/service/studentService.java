package com.XK.service;

import com.XK.dao.studentDao;
import com.XK.model.courseModel;
import com.XK.model.studentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class studentService {

    private studentDao studentDao;
    @Autowired
    public void setStudentDao(studentDao studentDao){
        this.studentDao = studentDao;
    }

    //学生登录
    public String getStudentPass(String sno){
        studentModel studentModel = new studentModel();
        studentModel.setSno(sno);
        return studentDao.getStudentPass(studentModel);
    }

    //加入学生信息
    public void insertStudent(String sno, String spass, String sname, String sex, String tel, String departmentno){
        studentModel studentModel = new studentModel();
        studentModel.setSno(sno);
        studentModel.setSpass(spass);
        studentModel.setSname(sname);
        studentModel.setSex(sex);
        studentModel.setTel(tel);
        studentModel.setDepartmentno(departmentno);
        studentDao.insertStudent(studentModel);
    }

    //获取最大学生编号
    public String getMaxStudentSno(){
        return studentDao.getMaxStudentSno();
    }

    //删除学生信息
    public void deleteStudent(String sno, String sname){
        studentModel studentModel = new studentModel();
        studentModel.setSno(sno);
        studentModel.setSname(sname);
        studentDao.deleteStudent(studentModel);
    }

    //查询学生信息
    public List<studentModel> getStudentInfo(String sno){
        studentModel studentModel = new studentModel();
        studentModel.setSno(sno);
        return studentDao.getStudentInfo(studentModel);
    }

    //查询全部学生信息
    public List<studentModel> getAllStudent(){
        return studentDao.getAllStudent();
    }

    //更新学生信息
    public void updateStudentInfo(String sno, String sex, String tel, String departmentno){
        studentModel studentModel = new studentModel();
        studentModel.setSno(sno);
        studentModel.setSex(sex);
        studentModel.setTel(tel);
        studentModel.setDepartmentno(departmentno);
        studentDao.updateStudentInfo(studentModel);
    }

    //更新学生信息密码
    public void updateStudentInfoPass(String sno, String spass, String tel){
        studentModel studentModel = new studentModel();
        studentModel.setSno(sno);
        studentModel.setSpass(spass);
        studentModel.setTel(tel);
        studentDao.updateStudentInfoPass(studentModel);
    }

    //根据成绩学号查询学生姓名
    public List<studentModel> getStudentNameFromScore(String cno){
        courseModel courseModel = new courseModel();
        courseModel.setCno(cno);
        return studentDao.getStudentNameFromScore(courseModel);
    }

}
