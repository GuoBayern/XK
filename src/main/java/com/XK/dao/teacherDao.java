package com.XK.dao;

import com.XK.model.teacherModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface teacherDao {

    //教师登录
    @Select("select cpass from teacher where cno = #{cno}")
    public String getTeacherPass(teacherModel teacherModel);

}
