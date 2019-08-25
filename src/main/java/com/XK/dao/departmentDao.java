package com.XK.dao;

import com.XK.model.departmentModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface departmentDao {

    //查询学院编号
    @Select("select departmentno from department where departmentname = #{departmentname}")
    public String getDepartmentNo(departmentModel departmentModel);

    //查询学院名称
    @Select("select departmentname from department where departmentno = #{departmentno}")
    public String getDepartmentName(departmentModel departmentModel);

}
