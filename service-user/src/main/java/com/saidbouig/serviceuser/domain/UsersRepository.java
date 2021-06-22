package com.saidbouig.serviceuser.domain;

import java.util.List;
import java.util.Optional;

public interface UsersRepository {
    List<User> findAll();

    Optional<User> findById(Long userId);

    User save(User user);

    void delete(User user);
}
