package com.example.demo.util;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.*;

public class ConfigureMessage {

    public static Message message (String addressTo, String addressCc, String addressBcc, String subject){

        // You can send an array of emails like this:
        // String address = "test0@gmail.com,test1@gmail.com";

        try{
            final String fromEmail = Constants.fromEmail; //requires valid gmail id
            final String password = Constants.pass; // correct password for gmail id
//          final String toEmail = "driving.school.test.email@gmail.com";

            //Set the properties
            Properties props = new Properties();
            //Change it with appropriate SMTP host
            props.put("mail.smtp.host", "smtp.gmail.com");
//          props.put("mail.smtp.port", 587);
//          props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.port", 465);
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.socketFactory.port", 465);
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

            Authenticator auth = new Authenticator() {
                //override the getPasswordAuthentication method
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            };

            Message message = new MimeMessage(Session.getInstance(props, auth));
            message.setFrom(new InternetAddress(fromEmail));

            InternetAddress[] toAdressArray = InternetAddress.parse(addressTo);
            InternetAddress[] ccAdressArray = InternetAddress.parse(addressCc);
            InternetAddress[] bccAdressArray = InternetAddress.parse(addressBcc);

            message.addRecipients(Message.RecipientType.TO, toAdressArray);
            message.addRecipients(Message.RecipientType.CC, ccAdressArray);
            message.addRecipients(Message.RecipientType.BCC, bccAdressArray);
            message.setSubject(subject);
            return message;
        }catch (MessagingException e) {
            e.printStackTrace();
            return null;
        }

    }


}
