package com.XK.dao;

import com.XK.model.classroomModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface classroomDao {

    //增加教室
    @Insert("insert into classroom(courseaddress) values (#{courseaddress})")
    public void insertClassroom(classroomModel classroomModel);

    //查询教室
    @Select("select courseaddress from classroom")
    public List<classroomModel> getClassroomAddress();

    /*获取每个时间段是否有教室*/
    @Select("select count(Mon1) from classroom where Mon1 = 'no'")
    public String getMon1();
    @Select("select count(Mon2) from classroom where Mon2 = 'no'")
    public String getMon2();
    @Select("select count(Mon3) from classroom where Mon3 = 'no'")
    public String getMon3();
    @Select("select count(Mon4) from classroom where Mon4 = 'no'")
    public String getMon4();
    @Select("select count(Tue1) from classroom where Tue1 = 'no'")
    public String getTue1();
    @Select("select count(Tue2) from classroom where Tue2 = 'no'")
    public String getTue2();
    @Select("select count(Tue3) from classroom where Tue3 = 'no'")
    public String getTue3();
    @Select("select count(Tue4) from classroom where Tue4 = 'no'")
    public String getTue4();
    @Select("select count(Wed1) from classroom where Wed1 = 'no'")
    public String getWed1();
    @Select("select count(Wed2) from classroom where Wed2 = 'no'")
    public String getWed2();
    @Select("select count(Wed3) from classroom where Wed3 = 'no'")
    public String getWed3();
    @Select("select count(Wed4) from classroom where Wed4 = 'no'")
    public String getWed4();
    @Select("select count(Thu1) from classroom where Thu1 = 'no'")
    public String getThu1();
    @Select("select count(Thu2) from classroom where Thu2 = 'no'")
    public String getThu2();
    @Select("select count(Thu3) from classroom where Thu3 = 'no'")
    public String getThu3();
    @Select("select count(Thu4) from classroom where Thu4 = 'no'")
    public String getThu4();
    @Select("select count(Fri1) from classroom where Fri1 = 'no'")
    public String getFri1();
    @Select("select count(Fri2) from classroom where Fri2 = 'no'")
    public String getFri2();
    @Select("select count(Fri3) from classroom where Fri3 = 'no'")
    public String getFri3();

}
