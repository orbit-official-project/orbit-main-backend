package kr.codemons.orbitproject.domain.service;

import kr.codemons.orbitproject.domain.dto.RequestEmailAuthentication;
import kr.codemons.orbitproject.domain.dto.RequestUserAuthSignIn;
import kr.codemons.orbitproject.domain.dto.RequestUserAuthSignUp;
import kr.codemons.orbitproject.domain.dto.response.ResponseUserProfile;
import kr.codemons.orbitproject.domain.entity.cache.EmailSession;
import kr.codemons.orbitproject.domain.entity.user.User;
import kr.codemons.orbitproject.domain.exception.user.*;
import kr.codemons.orbitproject.domain.repository.UserRepository;
import kr.codemons.orbitproject.domain.utils.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserAuthServiceImpl implements UserAuthService {
	
	private final UserRepository userRepository;
	private final RedisEmailSessionService redisEmailSessionService;
	private final JwtProvider jwtProvider;

	@Override
	public ResponseUserProfile login (RequestUserAuthSignIn dto) {
		User findUser = userRepository.findByEmail(dto.getEmail())
				.orElseThrow(UserNotFoundException::new);

		if (!findUser.getPassword().equals(dto.getPassword())) {
			throw new UserNotFoundException(); }

		String token = jwtProvider.createToken(1, findUser.getEmail());

		return new ResponseUserProfile(token, findUser.getEmail(),
				findUser.getHandler(), findUser.getAvatar());
	}

	@Override
	public synchronized void join (RequestUserAuthSignUp dto) {
		
		// TODO - 이메일 인증코드 유효성 검증
		if (!isAuthenticatedEmail(dto.getEmail())) {
			throw new UnAuthenticatedEmailException();
		}

		// 이메일, 핸들러 중복 확인
		if (isExistEmail(dto.getEmail())) {
			throw new DuplicateEmailException();
		}
		
		if (isExistHandler(dto.getHandler())) {
			throw new DuplicateHandlerException();
		}

		// DB에 유저 등록
		userRepository.save(dto.toUserEntity());
		redisEmailSessionService.delete(dto.getEmail());
	}

	@Override
	@Transactional
	public void emailAuthenticate (RequestEmailAuthentication authentication) {
		EmailSession emailSession = redisEmailSessionService.get(authentication.getEmail());

		if (isExistEmail(authentication.getEmail())) {
			throw new DuplicateEmailException();
		}

		if (emailSession.isDone() || !emailSession.getCode().equals(authentication.getInputCode())) {
			throw new MalformedEmailAuthentication();
		}

		emailSession.done();
		redisEmailSessionService.save(emailSession);
	}

	
	@Override
	public boolean validateUserToken (String token) {
		return false;
	}
	
	@Override
	public boolean isExistEmail(String email) {
		Optional<User> findUserByEmailOpt = userRepository.findByEmail(email);
		return findUserByEmailOpt.isPresent();
	}

	private boolean isExistHandler(String handler) {
		Optional<User> findUserByHandlerOpt = userRepository.findByHandler(handler);
		return findUserByHandlerOpt.isPresent();
	}

	private boolean isAuthenticatedEmail (String email) {
		return redisEmailSessionService.get(email).isDone();
	}
}
