package tn.dari.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	public final JavaMailSender emailSender;

    @Autowired
    public MailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }
	public void sendMail() {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("ibtihel.bedoui1@esprit.tn");
        message.setSubject("Credit Simulated!");
        message.setText("Congrats");
        System.out.println(message.toString());
 try {
            emailSender.send(message);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}

