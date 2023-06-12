package kr.codemons.orbitproject.domain.repository;

import kr.codemons.orbitproject.domain.entity.server.EnableServer;
import kr.codemons.orbitproject.domain.entity.server.Server;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnableServerRepository extends JpaRepository<EnableServer, Long> {

    Optional<EnableServer> findByServer (Server server);
}
