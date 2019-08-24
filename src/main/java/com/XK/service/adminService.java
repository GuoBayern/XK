package com.XK.service;

import com.XK.dao.adminDao;
import com.XK.model.adminModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class adminService {

    private adminDao adminDao;
    @Autowired
    public void setAdminDao(adminDao adminDao){
        this.adminDao = adminDao;
    }

    //管理员登录
    public String getAdminPass(String adminno){
        adminModel adminModel = new adminModel();
        adminModel.setAdminno(adminno);
        return adminDao.getAdminPass(adminModel);
    }

}
