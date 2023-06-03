package kr.codemons.orbitproject.domain.service;

import kr.codemons.orbitproject.domain.dto.UserAuthJoinDto;
import kr.codemons.orbitproject.domain.entity.user.User;
import kr.codemons.orbitproject.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserAuthServiceImpl implements UserAuthService {

    private final UserRepository userRepository;

    @Override
    public void join (UserAuthJoinDto dto) {

    }

    @Override
    public boolean validateUserToken(String token) {
        return false;
    }

    private boolean isExistsEmail (String email) {
        Optional<User> findUserByEmailOpt = userRepository.findByEmail(email);
        return findUserByEmailOpt.isPresent();
    }
}
