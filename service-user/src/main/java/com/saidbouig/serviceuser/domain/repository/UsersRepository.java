package com.saidbouig.serviceuser.domain.repository;

import com.saidbouig.serviceuser.domain.User;

import java.util.List;
import java.util.Optional;

public interface UsersRepository {
    List<User> findAll();

    Optional<User> findById(Long userId);

    User save(User user);

    void delete(User user);
}
