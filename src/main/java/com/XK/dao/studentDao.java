package com.XK.dao;

import com.XK.model.studentModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface studentDao {

    //学生登录
    @Select("select spass from student where sno = #{sno}")
    public String getStudentPass(studentModel studentModel);

}
