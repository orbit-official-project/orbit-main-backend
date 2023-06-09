package kr.codemons.orbitproject.domain.service;

import kr.codemons.orbitproject.domain.entity.user.User;

import java.util.List;

public interface UserService {

    User findByName (String name);

    User findByHandler (String handler);
    List<User> getAll ();
}
