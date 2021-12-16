/*package Practice23.services;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
public class EmailService {
    private final JavaMailSender sender;
    @Value("${spring.mail.username}")
    private String username;
    @Value("${mail.to}")
    private String emailTo;

    @Autowired
    public EmailService(JavaMailSender sender) {
        this.sender = sender;
    }

    @Async
    public void send(String subject, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(username);
        mailMessage.setTo(emailTo);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        sender.send(mailMessage);
        log.info("Email with subject '{}' and text '{}' was sent to '{}' from '{}'.", subject, message, emailTo, username);
    }
}*/