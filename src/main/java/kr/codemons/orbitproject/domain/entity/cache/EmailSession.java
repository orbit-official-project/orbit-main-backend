package kr.codemons.orbitproject.domain.entity.cache;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

/**
 * Redis Entity
 *
 *
 */

@Getter
@RedisHash(value = "EmailSession")
public class EmailSession {

    @Id
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
