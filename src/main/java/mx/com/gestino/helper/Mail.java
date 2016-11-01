/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gestino.helper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author developer
 */
public class Mail {

    public Mail() {
    }

    public String sender(String file, String xmlFile) {

        Properties prop = new Properties();
        InputStream fileProperties = getClass().getClassLoader().getResourceAsStream("emailConfig.properties");
        try {
            prop.load(fileProperties);
        } catch (IOException ex) {
            Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
        }
        String to =  prop.getProperty("mail.email.to");

        String from = prop.getProperty("mail.email.from");;

        final String username = prop.getProperty("mail.user");
        final String password = prop.getProperty("mail.password");
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));

            message.setSubject("Testing Subject");

            BodyPart messageBodyPart = new MimeBodyPart();

            messageBodyPart.setText("Invoice Gestino");

            Multipart multipart = new MimeMultipart();

            multipart.addBodyPart(messageBodyPart);

            addAttachment(multipart, file);
            addAttachment(multipart, xmlFile);
            multipart.addBodyPart(messageBodyPart);

            message.setContent(multipart);
            Transport.send(message);
            System.out.println("Sent message successfully....");

        } catch (MessagingException e) {
            System.err.println(e);
        }
        return "successfully";
    }
    
    private void addAttachment(Multipart multipart, String filename)
{
        try {
            DataSource source = new FileDataSource(filename);
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(new File(filename).getName());
            multipart.addBodyPart(messageBodyPart);
        } catch (MessagingException ex) {
            Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
        }
}

}
