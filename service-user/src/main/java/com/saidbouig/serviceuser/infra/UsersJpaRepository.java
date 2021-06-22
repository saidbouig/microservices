package com.saidbouig.serviceuser.infra;

import com.saidbouig.serviceuser.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersJpaRepository extends JpaRepository<User, Long> {
}