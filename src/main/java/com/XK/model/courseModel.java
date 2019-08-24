package com.XK.model;

import java.io.Serializable;

public class courseModel implements Serializable {

    private String courseno;
    private String coursename;
    private String credit;
    private String departmentno;
    private String weekday;
    private String worktime;
    private String courseaddress;

    public String getCourseno() {
        return courseno;
    }

    public void setCourseno(String courseno) {
        this.courseno = courseno;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getDepartmentno() {
        return departmentno;
    }

    public void setDepartmentno(String departmentno) {
        this.departmentno = departmentno;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public String getWorktime() {
        return worktime;
    }

    public void setWorktime(String worktime) {
        this.worktime = worktime;
    }

    public String getCourseaddress() {
        return courseaddress;
    }

    public void setCourseaddress(String courseaddress) {
        this.courseaddress = courseaddress;
    }
}
