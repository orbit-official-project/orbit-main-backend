package kr.codemons.orbitproject.domain.entity.cache;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

/**
 * Redis Entity
 */

@Getter
@RedisHash(value = "EmailSession", timeToLive = 300L)
public class EmailSession {

	public EmailSession (String email, String code) {
		this.email = email;
		this.code = code;
		this.done = false;
	}

	@Id
	private String email;
	private String code;
	private boolean done;


	public void done() {
		this.done = true;
	}
}
