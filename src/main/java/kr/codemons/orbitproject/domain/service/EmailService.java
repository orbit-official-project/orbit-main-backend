package kr.codemons.orbitproject.domain.service;

public interface EmailService {

    void sendCertificationMail (String email);
    String createCode (String seed);

}
