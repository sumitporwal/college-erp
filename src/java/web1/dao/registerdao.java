/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web1.dao;

import com.mysql.jdbc.Blob;
import java.io.InputStream;

/**
 *
 * @author Windows
 */
public class registerdao {
   private String name;
   private String email;
   private String phno;
   private String password;
   private String userid;
   private String stream;
   private String branch;
   private String sem;
   private String clas;
   private String photo;
   private String filename;
   
    public registerdao() {
    }

    public registerdao(String name, String email, String phno, String password, String userid, String stream, String branch, String sem, String clas, String photo, String filename) {
        this.name = name;
        this.email = email;
        this.phno = phno;
        this.password = password;
        this.userid = userid;
        this.stream = stream;
        this.branch = branch;
        this.sem = sem;
        this.clas = clas;
        this.photo = photo;
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setSem(String sem) {
        this.sem = sem;
    }

    public String getSem() {
        return sem;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getPhoto() {
        return photo;
    }

    public String getStream() {
        return stream;
    }
   
    public String getBranch() {
        return branch;
    }

    public String getClas() {
        return clas;
    }

  

    public String getUserid() {
        return userid;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getPhno() {
        return phno;
    }
   
}
