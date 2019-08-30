package com.XK.dao;

import com.XK.model.courseModel;
import com.XK.model.scoreModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface scoreDao {

    //查询学生是否加入该课程
    @Select("select courseno from score where courseno = #{courseno} and sno = #{sno}")
    public String getScoreCourseno(scoreModel scoreModel);

    //学生加入课程
    @Insert("insert into score(courseno, sno) values (#{courseno}, #{sno})")
    public void insertScoreStudent(scoreModel scoreModel);

    //学生是否已加入课程
    @Select("select courseno from score where courseno = #{courseno} and sno = #{sno}")
    public String getScoreCourseNo(scoreModel scoreModel);

    //学生退出课程
    @Delete("delete from score where courseno = #{courseno} and sno = #{sno}")
    public void deleteScore(scoreModel scoreModel);

    //学生查询成绩
    @Select("select courseno, score from score where sno = #{sno}")
    public List<scoreModel> getStudentScore(scoreModel scoreModel);

    //教师查询成绩
    @Select("select * from score, course where score.courseno = course.courseno and course.cno = #{cno}")
    public List<scoreModel> getTeacherScore(courseModel courseModel);

    //教师录入成绩
    @Update("update score set score = #{score} where courseno = #{courseno} and sno = #{sno}")
    public void updateScore(scoreModel scoreModel);

}
