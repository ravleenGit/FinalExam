package com.models;

public class StudentData
{
    String snumber;
    String sname;
    double gpa;

    public StudentData(String snumber, String sname, double gpa)
    {
        this.snumber = snumber;
        this.sname = sname;
        this.gpa = gpa;
    }

    public String getSnumber() {
        return snumber;
    }

    public void setSnumber(String snumber) {
        this.snumber = snumber;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}
