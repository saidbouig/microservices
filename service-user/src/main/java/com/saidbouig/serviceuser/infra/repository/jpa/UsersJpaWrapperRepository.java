package com.saidbouig.serviceuser.infra.repository.jpa;

import com.saidbouig.serviceuser.domain.User;
import com.saidbouig.serviceuser.domain.repository.UsersRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UsersJpaWrapperRepository implements UsersRepository {

    private final UsersJpaRepository usersJpaRepository;

    public UsersJpaWrapperRepository(UsersJpaRepository usersJpaRepository) {
        this.usersJpaRepository = usersJpaRepository;
    }

    @Override
    public List<User> findAll() {
        var userJpaEntities = usersJpaRepository.findAll();

        return userJpaEntities.stream()
            .map(UserJpaEntity::toUser)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<User> findById(Long userId) {
        var userEntity = usersJpaRepository.findById(userId);
        return userEntity.map(UserJpaEntity::toUser);
    }

    @Override
    public User save(User user) {
        var savedUserEntity = usersJpaRepository.save(new UserJpaEntity(user));
        return savedUserEntity.toUser();
    }

    @Override
    public void delete(User user) {
        usersJpaRepository.delete(new UserJpaEntity(user));
    }
}

