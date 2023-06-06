package kr.codemons.orbitproject.domain.service;

import kr.codemons.orbitproject.domain.entity.cache.EmailSession;
import kr.codemons.orbitproject.domain.repository.redis.EmailSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RedisEmailSessionService {

    private final EmailSessionRepository emailSessionRepository;

    public void add (String email, String code) {
        EmailSession emailSession = new EmailSession(email, code, 1);

        if (isExist(emailSession.getEmail())) {
            emailSessionRepository.delete(emailSession);
        }

        emailSessionRepository.save(emailSession);
    }

    public Optional<EmailSession> get (String key) {
        return emailSessionRepository.findByEmail(key);
    }

    private boolean isExist (String key) {
        return emailSessionRepository.existsById(key);
    }
}