package kr.codemons.orbitproject.domain.repository.redis;


import kr.codemons.orbitproject.domain.entity.cache.EmailSession;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EmailSessionRepository extends CrudRepository<EmailSession, String> { }
