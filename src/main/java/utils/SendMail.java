/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Properties;
import javax.mail.Session;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
/**
 *
 * @author ASUS
 */
public class SendMail {
   
/* public static void sendMail(String userMail,String pass,String sujet,String contenu) throws MessagingException{
    
        
        String to = "ayman.kobbi@esprit.tn";
        String host = "smtp.aol.com";
        Properties prop = System.getProperties();
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put( "mail.smtp.host", host );
        prop.put("mail.smtp.user", userMail);
        prop.put("mail.smtp.password", pass);
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.ssl.trust", "smtp.aol.com");
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(userMail, pass);
                    }
                });
     // Session session = Session.getDefaultInstance(prop);
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(userMail));
         
        InternetAddress toAdresse = new InternetAddress(to);
                
        msg.setRecipient(Message.RecipientType.TO, toAdresse);
        msg.setSubject(sujet);
        msg.setContent(contenu,"text/html; charset=utf-8");
        Transport transport = session.getTransport("smtp");
        transport.connect(host, userMail, pass);
        transport.sendMessage(msg, msg.getAllRecipients());
        transport.close();
    
          
        
        
    }*/
}
   


