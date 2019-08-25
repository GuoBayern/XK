package com.XK.dao;

import com.XK.model.teacherModel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface teacherDao {

    //教师登录
    @Select("select cpass from teacher where cno = #{cno}")
    public String getTeacherPass(teacherModel teacherModel);

    //加入教师信息
    @Insert("insert into teacher values (#{cno}, #{cpass}, #{cname}, #{sex}, #{tel}, #{departmentno}, #{degree})")
    public void insertTeacher(teacherModel teacherModel);

    //获取教师最大编号
    @Select("select max(cno) from teacher")
    public String getMaxTeacherCno();

    //删除教师信息
    @Delete("delete from teacher where cno = #{cno} and cname = #{cname}")
    public void deleteTeacher(teacherModel teacherModel);

    //查询教师信息
    @Select("select * from teacher where cno = #{cno}")
    public List<teacherModel> getTeacherInfo(teacherModel teacherModel);

    //查询全部教师信息
    @Select("select * from teacher")
    public List<teacherModel> getAllTeacher();

}
