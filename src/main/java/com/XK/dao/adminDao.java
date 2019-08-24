package com.XK.dao;

import com.XK.model.adminModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface adminDao {

    //管理员登录
    @Select("select adminpass from admin where adminno = #{adminno}")
    public String getAdminPass(adminModel adminModel);

}
