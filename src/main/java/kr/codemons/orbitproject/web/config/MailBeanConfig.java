package kr.codemons.orbitproject.web.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailBeanConfig {

    @Value("${smtp.host}") private String smtpHost;
    @Value("${smtp.email}") private String smtpEmail;
    @Value("${smtp.password}") private String smtpPwd;
    @Value("${smtp.port}") private Integer smtpPort;

    @Bean
    public JavaMailSender javaMailSender () {
        return initMailSender();
    }

    private JavaMailSender initMailSender () {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost(smtpHost);
        sender.setUsername(smtpEmail);
        sender.setPassword(smtpPwd);
        sender.setPort(smtpPort);
        sender.setJavaMailProperties(getMailProperties());
        return sender;
    }

    private Properties getMailProperties() {
        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.debug", "true");
        properties.setProperty("mail.smtp.ssl.trust","smtp.naver.com");
        properties.setProperty("mail.smtp.ssl.enable","true");
        return properties;
    }
}
