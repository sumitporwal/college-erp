package web1.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Windows
 */
public class welcomedao {
   private String subjectid;
   private String subjectname;
   private String attended;
   private int attendance;
   private int total;
   private String date;
   private double percent;
   private String userid;
   private String userid1;

    public welcomedao() {
    }

    public welcomedao(String subjectid, String subjectname, String attended, int attendance, int total, String date, double percent, String userid, String userid1) {
        this.subjectid = subjectid;
        this.subjectname = subjectname;
        this.attended = attended;
        this.attendance = attendance;
        this.total = total;
        this.date = date;
        this.percent = percent;
        this.userid = userid;
        this.userid1 = userid1;
    }

    public String getSubjectid() {
        return subjectid;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public String getAttended() {
        return attended;
    }

    public int getAttendance() {
        return attendance;
    }

    public int getTotal() {
        return total;
    }

    public String getDate() {
        return date;
    }

    public double getPercent() {
        return percent;
    }

    public String getUserid() {
        return userid;
    }

    public String getUserid1() {
        return userid1;
    }

    public void setSubjectid(String subjectid) {
        this.subjectid = subjectid;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public void setAttended(String attended) {
        this.attended = attended;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setUserid1(String userid1) {
        this.userid1 = userid1;
    }

   
}
