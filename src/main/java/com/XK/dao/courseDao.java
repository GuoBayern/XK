package com.XK.dao;

import com.XK.model.courseModel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface courseDao {

    //开课
    @Insert("insert into course(courseno, cno, coursename, credit, departmentno) values (#{courseno}, #{cno}, #{coursename}, #{credit}, #{departmentno})")
    public void insertOpenCourse(courseModel courseModel);

    //关课
    @Delete("delete from course where courseno = #{courseno}")
    public void deleteCloseCourse(courseModel courseModel);

    //查询最大课程号
    @Select("select max(courseno) from course")
    public String getMaxCourseno();

}
