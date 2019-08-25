package com.XK.dao;

import com.XK.model.studentModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface studentDao {

    //学生登录
    @Select("select spass from student where sno = #{sno}")
    public String getStudentPass(studentModel studentModel);

    //加入学生信息
    @Insert("insert into student values (#{sno}, #{spass}, #{sname}, #{sex}, #{tel}, #{departmentno})")
    public void insertStudent(studentModel studentModel);

    //获取最大学生编号
    @Select("select max(sno) from student")
    public String getMaxStudentSno();

}
