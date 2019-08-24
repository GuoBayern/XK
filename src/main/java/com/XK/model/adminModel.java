package com.XK.model;

import java.io.Serializable;

public class adminModel implements Serializable {

    private String adminno;
    private String adminpass;

    public String getAdminno() {
        return adminno;
    }

    public void setAdminno(String adminno) {
        this.adminno = adminno;
    }

    public String getAdminpass() {
        return adminpass;
    }

    public void setAdminpass(String adminpass) {
        this.adminpass = adminpass;
    }
}
