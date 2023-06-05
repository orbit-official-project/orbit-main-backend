package kr.codemons.orbitproject.domain.entity.cache;

import jakarta.persistence.Id;
import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@RedisHash(value = "email_session")
public class EmailSession {

    @Id @Indexed
    private String email;

    private String code;

    @TimeToLive
    private Integer expired;

    protected  EmailSession() {}

    public EmailSession(String email, String code, Integer expired) {
        this.email = email;
        this.code = code;
        this.expired = expired;
    }
}
