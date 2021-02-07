/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web1.dao;

import java.io.InputStream;

/**
 *
 * @author Windows
 */
public class registerteacherdao {
  private String name;
   private String email;
   private String phno;
   private String password;
   private String userid;
   private String branch;
   private String photo;
   private String filename;

    public registerteacherdao() {
    }

    public registerteacherdao(String name, String email, String phno, String password, String userid, String branch, String photo,String filename) {
        this.name = name;
        this.email = email;
        this.phno = phno;
        this.password = password;
        this.userid = userid;
        this.branch = branch;
        this.photo = photo;
        this.filename=filename;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
    
    
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    
    public String getBranch() {
        return branch;
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

    public String getUserid() {
        return userid;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
   
}
