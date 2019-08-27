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
    @Select("select distinct Mon1 from classroom")
    public String getMon1();
    @Select("select distinct Mon2 from classroom")
    public String getMon2();
    @Select("select distinct Mon3 from classroom")
    public String getMon3();
    @Select("select distinct Mon4 from classroom")
    public String getMon4();
    @Select("select distinct Tue1 from classroom")
    public String getTue1();
    @Select("select distinct Tue2 from classroom")
    public String getTue2();
    @Select("select distinct Tue3 from classroom")
    public String getTue3();
    @Select("select distinct Tue4 from classroom")
    public String getTue4();
    @Select("select distinct Wed1 from classroom")
    public String getWed1();
    @Select("select distinct Wed2 from classroom")
    public String getWed2();
    @Select("select distinct Wed3 from classroom")
    public String getWed3();
    @Select("select distinct Wed4 from classroom")
    public String getWed4();
    @Select("select distinct Thu1 from classroom")
    public String getThu1();
    @Select("select distinct Thu2 from classroom")
    public String getThu2();
    @Select("select distinct Thu3 from classroom")
    public String getThu3();
    @Select("select distinct Thu4 from classroom")
    public String getThu4();
    @Select("select distinct Fri1 from classroom")
    public String getFri1();
    @Select("select distinct Fri2 from classroom")
    public String getFri2();
    @Select("select distinct Fri3 from classroom")
    public String getFri3();

}
