package com.XK.dao;

import com.XK.model.courseModel;
import com.XK.model.scoreModel;
import org.apache.ibatis.annotations.*;

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

    //更新课程教室
    @Update("update course set weekday = #{weekday}, worktime = #{worktime}, courseaddress = #{courseaddress} where courseno = #{courseno}")
    public void updateCourseAddress(courseModel courseModel);

    //查看教师课表
    @Select("select coursename, weekday, worktime, courseaddress from course where cno = #{cno}")
    public List<courseModel> getTeacherCourseInfo(courseModel courseModel);

    //根据课程号模糊查询
    @Select("select * from course where courseno like #{courseno}")
    public List<courseModel> getAllCourseInfo(courseModel courseModel);

    //根据课程名模糊查询
    @Select("select * from course where coursename like #{coursename}")
    public List<courseModel> getAllCourse(courseModel courseModel);

    //查看学生课表
    @Select("select coursename, weekday, worktime, courseaddress from course where courseno in (select courseno from score where sno = #{sno})")
    public List<courseModel> getStudentCourse(scoreModel scoreModel);

    //根据成绩课程号获取课程名
    @Select("select coursename from course, score where course.courseno = score.courseno and sno = #{sno}")
    public List<courseModel> getStudentScoreCourseName(scoreModel scoreModel);

    //根据成绩课程号获取学分
    @Select("select coursename, credit from course, score where course.courseno = score.courseno and sno = #{sno}")
    public List<courseModel> getStudentCreditCourseName(scoreModel scoreModel);

    //根据成绩课程号教师号获取课程名
    @Select("select coursename from course, score where course.courseno = score.courseno and cno = #{cno}")
    public List<courseModel> getTeacherScoreCourseName(courseModel courseModel);

}
