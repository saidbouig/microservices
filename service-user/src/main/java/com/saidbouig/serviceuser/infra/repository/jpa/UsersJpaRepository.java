package com.saidbouig.serviceuser.infra.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersJpaRepository extends JpaRepository<UserJpaEntity, Long> {
}
