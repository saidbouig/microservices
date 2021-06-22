package com.saidbouig.serviceuser.infra.repository.jpa;

import com.saidbouig.serviceuser.domain.User;
import com.saidbouig.serviceuser.domain.UsersRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsersJpaWrapperRepository implements UsersRepository {

    private final UsersJpaRepository usersJpaRepository;

    public UsersJpaWrapperRepository(UsersJpaRepository usersJpaRepository) {
        this.usersJpaRepository = usersJpaRepository;
    }

    @Override
    public List<User> findAll() {
        return usersJpaRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long userId) {
        return usersJpaRepository.findById(userId);
    }

    @Override
    public User save(User user) {
        return usersJpaRepository.save(user);
    }

    @Override
    public void delete(User user) {
        usersJpaRepository.delete(user);
    }
}

