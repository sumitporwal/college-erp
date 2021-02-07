/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web1.dao;

/**
 *
 * @author Windows
 */
public class StudentImageDao {
    private int scholarno;
    private String stream; 
    private String clas;
    private String name;
    private String base64Image;

    public StudentImageDao() {
    }

    public StudentImageDao(int scholarno, String stream, String clas, String name, String base64Image) {
        this.scholarno = scholarno;
        this.stream = stream;
        this.clas = clas;
        this.name = name;
        this.base64Image = base64Image;
    }
    
    
    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getStream() {
        return stream;
    }
    
    public void setClas(String clas) {
        this.clas = clas;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScholarno(int scholarno) {
        this.scholarno = scholarno;
    }

    public String getClas() {
        return clas;
    }

    public String getName() {
        return name;
    }

    public int getScholarno() {
        return scholarno;
    }
 
    public String getBase64Image() {
        return base64Image;
    }
 
    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }
 
}
