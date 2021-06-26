package com.saidbouig.serviceuser.domain.service;

import com.saidbouig.serviceuser.domain.ResourceNotFoundException;
import com.saidbouig.serviceuser.domain.User;
import com.saidbouig.serviceuser.domain.repository.UsersRepository;

import java.util.Date;
import java.util.List;

public class DomainUserService implements UserService {
    private final UsersRepository usersRepository;

    public DomainUserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public User getById(Long userId) throws ResourceNotFoundException {
        return usersRepository
            .findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
    }

    @Override
    public List<User> getAll() {
        return usersRepository.findAll();
    }

    @Override
    public User create(User user) {
        return usersRepository.save(user);
    }

    @Override
    public User update(Long userId, User userDetails) throws ResourceNotFoundException {
        User user = usersRepository
            .findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));

        user.setEmail(userDetails.getEmail());
        user.setLastName(userDetails.getLastName());
        user.setFirstName(userDetails.getFirstName());
        user.setUpdatedAt(new Date());

        return user;
    }

    @Override
    public void delete(Long userId) throws ResourceNotFoundException {
        User user =
            getById(userId);

        usersRepository.delete(user);
    }
}
