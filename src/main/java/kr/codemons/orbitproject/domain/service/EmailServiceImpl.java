package kr.codemons.orbitproject.domain.service;

import jakarta.mail.internet.MimeMessage;
import kr.codemons.orbitproject.domain.entity.cache.EmailSession;
import kr.codemons.orbitproject.domain.exception.user.InitMessageHelperException;
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
	
	@Value("${smtp.email}")
	private String smtpEmail;
	
	@Override
	public String sendCertificatedMail(String email) {
		String code = createCode();
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = initializeMimeMessageHelper(message, email, code);
		javaMailSender.send(message);
		
		redisEmailSessionService.save(new EmailSession(email, code));
		return code;
	}
	
	private String createCode() {
		return String.valueOf((int)(Math.random() * (99999 - 10000 + 1)) + 10000);
	}
	
	private MimeMessageHelper initializeMimeMessageHelper(MimeMessage mimeMessage, String setTo, String code) {
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");
		
		try {
			helper.setFrom(smtpEmail);
			helper.setTo(setTo);
			helper.setSubject("[오르빗] 이메일 인증 코드가 도착했어요");
			helper.setText(code);
		} catch (Exception e) {
			throw new InitMessageHelperException();
		}
		
		return helper;
	}
}
