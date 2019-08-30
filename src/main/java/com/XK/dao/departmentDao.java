package com.XK.dao;

import com.XK.model.courseModel;
import com.XK.model.departmentModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface departmentDao {

    //查询学院编号
    @Select("select departmentno from department where departmentname = #{departmentname}")
    public String getDepartmentNo(departmentModel departmentModel);

    //查询学院名称
    @Select("select departmentname from department where departmentno = #{departmentno}")
    public String getDepartmentName(departmentModel departmentModel);

    //根据课程号查询学院名称
    @Select("select department.departmentname from department, course where department.departmentno = course.departmentno and courseno like #{courseno}")
    public List<departmentModel> getDepartmentNameFromCourse(courseModel courseModel);

    //根据课程名查询学院名称
    @Select("select department.departmentname from department, course where department.departmentno = course.departmentno and coursename like #{coursename}")
    public List<departmentModel> getDepartmentNameFromCourseName(courseModel courseModel);

}
