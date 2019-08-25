package com.XK.dao;

import com.XK.model.departmentModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface departmentDao {

    //查询学院名称
    @Select("select departmentno from department where departmentname = #{departmentname}")
    public String getDepartmentNo(departmentModel departmentModel);

}
