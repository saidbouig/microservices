package com.saidbouig.serviceuser.domain;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {
    private final UsersRepository usersRepository;

    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public User getById(Long userId) throws ResourceNotFoundException {
        return usersRepository
            .findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
    }

    public List<User> getAll() {
        return usersRepository.findAll();
    }

    public User create(User user) {
        return usersRepository.save(user);
    }

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

    public void delete(Long userId) throws ResourceNotFoundException {
        User user =
            getById(userId);

        usersRepository.delete(user);
    }
}
