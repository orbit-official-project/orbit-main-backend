package kr.codemons.orbitproject.domain.service;

import jakarta.mail.MessagingException;

public interface EmailService {

    void sendCertificationMail (String email);

}
