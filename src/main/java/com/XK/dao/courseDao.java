package com.XK.dao;

import com.XK.model.courseModel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface courseDao {

    //开课
    @Insert("insert into course(courseno, cno, coursename, credit, departmentno) values (#{courseno}, #{cno}, #{coursename}, #{credit}, #{departmentno})")
    public void insertOpenCourse(courseModel courseModel);

    //关课
    @Delete("delete from course where courseno = #{courseno} and coursename = #{coursename}")
    public void deleteCloseCourse(courseModel courseModel);

    //查询最大课程号
    @Select("select max(courseno) from course")
    public String getMaxCourseno();

    //查询开课教师号码
    @Select("select cno from course where courseno = #{courseno}")
    public String getCourseCno(courseModel courseModel);

    //查询课程名
    @Select("select coursename from course where courseno = #{courseno}")
    public String getCourseCoursename(courseModel courseModel);

    //查询课程上课信息
    @Select("select weekday, worktime, courseaddress from course where courseno = #{courseno}")
    public List<courseModel> getCourseInfo(courseModel courseModel);

}
