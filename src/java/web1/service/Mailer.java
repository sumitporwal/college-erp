/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web1.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import web1.dao.setpassworddao;

/**
 *
 * @author Windows
 */
public class Mailer {
public static void send(String to,String from,String pass,String pass1){  
          Properties props =new Properties();    
          props.put("mail.smtp.host", "smtp.gmail.com");
          props.put("mail.smtp.port", "587");
          props.put("mail.smtp.auth", "true");
          props.put("mail.smtp.starttls.enable","true");
          Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
           protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication(from,pass);  
           }});
         
        try{ 
          MimeMessage message = new MimeMessage(session);
          message.setFrom(new InternetAddress(from));
          message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));   
           message.setSubject("Reset Password");    
           message.setText("Your New Password:"+pass1+"\n\n Login with this password"+"\n\n Change Password after Logging In");    
           Transport.send(message);    
        }
       
        catch (MessagingException e) {
            e.printStackTrace();
        }
   }

	 public static String link(int n) 
	{ 

//        	String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+ "0123456789"+ "abcdefghijklmnopqrstuvxyz"; 
                String AlphaNumericString = "abcdefghijklmnopqrstuvxyz"+ "0123456789"; 

		StringBuilder sb = new StringBuilder(n); 

		for (int i = 0; i <n; i++) { 
			int index = (int)(AlphaNumericString.length()* Math.random()); 
			sb.append(AlphaNumericString.charAt(index)); 
		} 

		return sb.toString(); 
	}
         
          public static void register(String pass1,String to)
    {
        try{
            String sql="update register set password=? where email=?";   
       Connection con=Mysql.MySqlConnection.getconnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(2, to);
            ps.setString(1,pass1);
           ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}  


