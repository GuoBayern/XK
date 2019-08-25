package com.XK.service;

import com.XK.dao.studentDao;
import com.XK.model.studentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
