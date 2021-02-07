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
public class setpassworddao {
    private String to;
   private String pass1;

    public setpassworddao() {
    }

    public setpassworddao(String to, String pass1) {
        this.to = to;
        this.pass1 = pass1;
    }

    public String getPass1() {
        return pass1;
    }

    public String getTo() {
        return to;
    }

    public void setPass1(String pass1) {
        this.pass1 = pass1;
    }

    public void setTo(String to) {
        this.to = to;
    }
   
}
