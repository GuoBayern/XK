package com.XK.dao;

import com.XK.model.classroomModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    /*查询时间段有空闲的教室*/
    @Select("select courseaddress from classroom where Mon1 != 'no'")
    public List<classroomModel> getRestClassroomMon1();
    @Select("select courseaddress from classroom where Mon2 != 'no'")
    public List<classroomModel> getRestClassroomMon2();
    @Select("select courseaddress from classroom where Mon3 != 'no'")
    public List<classroomModel> getRestClassroomMon3();
    @Select("select courseaddress from classroom where Mon4 != 'no'")
    public List<classroomModel> getRestClassroomMon4();
    @Select("select courseaddress from classroom where Tue1 != 'no'")
    public List<classroomModel> getRestClassroomTue1();
    @Select("select courseaddress from classroom where Tue2 != 'no'")
    public List<classroomModel> getRestClassroomTue2();
    @Select("select courseaddress from classroom where Tue3 != 'no'")
    public List<classroomModel> getRestClassroomTue3();
    @Select("select courseaddress from classroom where Tue4 != 'no'")
    public List<classroomModel> getRestClassroomTue4();
    @Select("select courseaddress from classroom where Wed1 != 'no'")
    public List<classroomModel> getRestClassroomWed1();
    @Select("select courseaddress from classroom where Wed2 != 'no'")
    public List<classroomModel> getRestClassroomWed2();
    @Select("select courseaddress from classroom where Wed3 != 'no'")
    public List<classroomModel> getRestClassroomWed3();
    @Select("select courseaddress from classroom where Wed4 != 'no'")
    public List<classroomModel> getRestClassroomWed4();
    @Select("select courseaddress from classroom where Thu1 != 'no'")
    public List<classroomModel> getRestClassroomThu1();
    @Select("select courseaddress from classroom where Thu2 != 'no'")
    public List<classroomModel> getRestClassroomThu2();
    @Select("select courseaddress from classroom where Thu3 != 'no'")
    public List<classroomModel> getRestClassroomThu3();
    @Select("select courseaddress from classroom where Thu4 != 'no'")
    public List<classroomModel> getRestClassroomThu4();
    @Select("select courseaddress from classroom where Fri1 != 'no'")
    public List<classroomModel> getRestClassroomFri1();
    @Select("select courseaddress from classroom where Fri2 != 'no'")
    public List<classroomModel> getRestClassroomFri2();
    @Select("select courseaddress from classroom where Fri3 != 'no'")
    public List<classroomModel> getRestClassroomFri3();

    /*更新教室*/
    @Update("update classroom set Mon1 = '有课' where courseaddress = #{courseaddress}")
    public void updateClassroomMon1(classroomModel classroomModel);
    @Update("update classroom set Mon2 = '有课' where courseaddress = #{courseaddress}")
    public void updateClassroomMon2(classroomModel classroomModel);
    @Update("update classroom set Mon3 = '有课' where courseaddress = #{courseaddress}")
    public void updateClassroomMon3(classroomModel classroomModel);
    @Update("update classroom set Mon4 = '有课' where courseaddress = #{courseaddress}")
    public void updateClassroomMon4(classroomModel classroomModel);
    @Update("update classroom set Tue1 = '有课' where courseaddress = #{courseaddress}")
    public void updateClassroomTue1(classroomModel classroomModel);
    @Update("update classroom set Tue2 = '有课' where courseaddress = #{courseaddress}")
    public void updateClassroomTue2(classroomModel classroomModel);
    @Update("update classroom set Tue3 = '有课' where courseaddress = #{courseaddress}")
    public void updateClassroomTue3(classroomModel classroomModel);
    @Update("update classroom set Tue4 = '有课' where courseaddress = #{courseaddress}")
    public void updateClassroomTue4(classroomModel classroomModel);
    @Update("update classroom set Wed1 = '有课' where courseaddress = #{courseaddress}")
    public void updateClassroomWed1(classroomModel classroomModel);
    @Update("update classroom set Wed2 = '有课' where courseaddress = #{courseaddress}")
    public void updateClassroomWed2(classroomModel classroomModel);
    @Update("update classroom set Wed3 = '有课' where courseaddress = #{courseaddress}")
    public void updateClassroomWed3(classroomModel classroomModel);
    @Update("update classroom set Wed4 = '有课' where courseaddress = #{courseaddress}")
    public void updateClassroomWed4(classroomModel classroomModel);
    @Update("update classroom set Thu1 = '有课' where courseaddress = #{courseaddress}")
    public void updateClassroomThu1(classroomModel classroomModel);
    @Update("update classroom set Thu2 = '有课' where courseaddress = #{courseaddress}")
    public void updateClassroomThu2(classroomModel classroomModel);
    @Update("update classroom set Thu3 = '有课' where courseaddress = #{courseaddress}")
    public void updateClassroomThu3(classroomModel classroomModel);
    @Update("update classroom set Thu4 = '有课' where courseaddress = #{courseaddress}")
    public void updateClassroomThu4(classroomModel classroomModel);
    @Update("update classroom set Fri1 = '有课' where courseaddress = #{courseaddress}")
    public void updateClassroomFri1(classroomModel classroomModel);
    @Update("update classroom set Fri2 = '有课' where courseaddress = #{courseaddress}")
    public void updateClassroomFri2(classroomModel classroomModel);
    @Update("update classroom set Fri3 = '有课' where courseaddress = #{courseaddress}")
    public void updateClassroomFri3(classroomModel classroomModel);

}
