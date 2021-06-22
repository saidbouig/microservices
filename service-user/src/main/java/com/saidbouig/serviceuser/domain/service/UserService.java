package com.saidbouig.serviceuser.domain.service;

import com.saidbouig.serviceuser.domain.ResourceNotFoundException;
import com.saidbouig.serviceuser.domain.User;

import java.util.List;

public interface UserService {
    User getById(Long userId) throws ResourceNotFoundException;

    List<User> getAll();

    User create(User user);

    User update(Long userId, User userDetails) throws ResourceNotFoundException;

    void delete(Long userId) throws ResourceNotFoundException;
}
