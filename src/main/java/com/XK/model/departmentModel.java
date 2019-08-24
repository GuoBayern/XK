package com.XK.model;

import java.io.Serializable;

public class departmentModel implements Serializable {

    private String departmentno;
    private String departmentname;

    public String getDepartmentno() {
        return departmentno;
    }

    public void setDepartmentno(String departmentno) {
        this.departmentno = departmentno;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }
}
