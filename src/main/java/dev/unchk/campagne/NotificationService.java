package dev.unchk.campagne;

import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationService {
    private final JavaMailSender javaMailSender;

    public void sendEmail(String email, String message) {
        try {
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setTo(email);
            msg.setSubject("DOSSIER DE CANDIDATURE");
            msg.setText(message + " \n" + "Merci de votre candidature " + " \n");
            javaMailSender.send(msg);
        } catch (Exception e) {
            System.out.println("SEND EMAIL DEFAULT ERROR" + e);
        }

    }
}
