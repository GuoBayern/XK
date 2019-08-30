package com.XK.dao;

import com.XK.model.courseModel;
import com.XK.model.teacherModel;
import org.apache.ibatis.annotations.*;

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

    //更新教师信息
    @Update("update teacher set sex = #{sex}, tel = #{tel}, departmentno = #{departmentno}, degree = #{degree} where cno = #{cno}")
    public void updateTeacherInfo(teacherModel teacherModel);

    //更新教师信息密码
    @Update("update teacher set cpass = #{cpass}, tel = #{tel} where cno = #{cno}")
    public void updateTeacherInfoPass(teacherModel teacherModel);

    //根据课程号查询教师姓名
    @Select("select teacher.cname from teacher, course where teacher.cno = course.cno and course.courseno like #{courseno}")
    public List<teacherModel> getTeacherNameFromCourse(courseModel courseModel);

    //根据课程名查询教师姓名
    @Select("select teacher.cname from teacher, course where teacher.cno = course.cno and course.coursename like #{coursename}")
    public List<teacherModel> getTeacherNameFromCourseName(courseModel courseModel);

}
