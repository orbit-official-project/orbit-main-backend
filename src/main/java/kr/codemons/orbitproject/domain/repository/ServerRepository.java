package kr.codemons.orbitproject.domain.repository;

import kr.codemons.orbitproject.domain.entity.server.Server;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerRepository extends JpaRepository<Server, String> {

}
