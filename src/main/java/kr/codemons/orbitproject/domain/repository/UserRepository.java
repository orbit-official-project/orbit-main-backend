package kr.codemons.orbitproject.domain.repository;

import kr.codemons.orbitproject.domain.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByName(String name);
	
	Optional<User> findByEmail(String email);
	
	Optional<User> findByHandler(String handler);
}
