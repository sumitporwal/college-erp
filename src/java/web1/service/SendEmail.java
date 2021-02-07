/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web1.service;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Windows
 */
public class SendEmail {
    public static void send(String to,String from,String pass){  
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
          message.setSubject("Attendance");    
          message.setText("Your Attendance is less than 75%.Please maintain your attendance");    
           Transport.send(message);    
        }
       
        catch (MessagingException e) {
            e.printStackTrace();
        }
        
        
   }

}
