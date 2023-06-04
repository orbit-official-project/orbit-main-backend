package kr.codemons.orbitproject.domain.service;

import jakarta.mail.internet.MimeMessage;
import kr.codemons.orbitproject.domain.exception.InitMessageHelperException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;

    @Value("${smtp.email}") private String smtpEmail;

    @Override
    public void sendCertificationMail (String email)  {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = initializeMimeMessageHelper(message, email);

        javaMailSender.send(message);
    }

    private String createCode (String seed) {
        return "testCode";
    }

    private MimeMessageHelper initializeMimeMessageHelper (MimeMessage mimeMessage, String setTo) {
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");

        try {
            helper.setFrom(smtpEmail);
            helper.setTo(setTo);
            helper.setSubject("test subject");
            helper.setText(createCode("dummyText"));
        }
        catch (Exception e) {
            throw new InitMessageHelperException();
        }

        return helper;
    }
}
