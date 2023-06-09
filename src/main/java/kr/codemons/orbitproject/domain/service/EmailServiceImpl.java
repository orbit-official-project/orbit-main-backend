package kr.codemons.orbitproject.domain.service;

import jakarta.mail.internet.MimeMessage;
import kr.codemons.orbitproject.domain.exception.InitMessageHelperException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;
    private final RedisEmailSessionService redisEmailSessionService;

    @Value("${smtp.email}") private String smtpEmail;

    @Override
    public String sendCertificationMail (String email)  {
        String code = createCode();
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = initializeMimeMessageHelper(message, email, code);
        javaMailSender.send(message);

        redisEmailSessionService.add(email, code);
        return code;
    }

    private String createCode () {
        return String.valueOf((int)(Math.random() * (99999 - 10000 + 1)) + 10000);
    }

    private MimeMessageHelper initializeMimeMessageHelper (MimeMessage mimeMessage, String setTo, String code) {
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");

        try {
            helper.setFrom(smtpEmail);
            helper.setTo(setTo);
            helper.setSubject("test subject");
            helper.setText(code);
        }
        catch (Exception e) {
            throw new InitMessageHelperException();
        }

        return helper;
    }
}
