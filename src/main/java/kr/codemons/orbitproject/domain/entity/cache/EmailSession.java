package kr.codemons.orbitproject.domain.entity.cache;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

/**
 * Redis Entity
 *
 *
 */

@Builder
@Getter
@RedisHash(value = "EmailSession", timeToLive = 300L)
public class EmailSession {

    @Id
    private String email;
    private String code;

}
