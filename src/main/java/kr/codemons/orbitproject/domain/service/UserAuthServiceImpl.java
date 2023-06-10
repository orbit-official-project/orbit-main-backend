package kr.codemons.orbitproject.domain.service;

import kr.codemons.orbitproject.domain.dto.UserAuthSignUpDto;
import kr.codemons.orbitproject.domain.entity.user.User;
import kr.codemons.orbitproject.domain.exception.DuplicateEmailException;
import kr.codemons.orbitproject.domain.exception.DuplicateHandlerException;
import kr.codemons.orbitproject.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserAuthServiceImpl implements UserAuthService {
	
	private final UserRepository userRepository;
	
	@Override
	public void join(UserAuthSignUpDto dto) {
		
		// TODO - 이메일 인증코드 유효성 검증
		
		// 이메일, 핸들러 중복 확인
		if (isExistsEmail(dto.getEmail())) {
			throw new DuplicateEmailException();
		}
		
		if (isExistsHandler(dto.getHandler())) {
			throw new DuplicateHandlerException();
		}
		
		// DB에 유저 등록
		userRepository.save(dto.toUserEntity());
	}
	
	@Override
	public void delete(String token) {
	
	}
	
	@Override
	public boolean validateUserToken(String token) {
		return false;
	}
	
	@Override
	public boolean isExistsEmail(String email) {
		Optional<User> findUserByEmailOpt = userRepository.findByEmail(email);
		return findUserByEmailOpt.isPresent();
	}
	
	private boolean isExistsHandler(String handler) {
		Optional<User> findUserByHandlerOpt = userRepository.findByHandler(handler);
		return findUserByHandlerOpt.isPresent();
	}
}
