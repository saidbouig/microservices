package com.saidbouig.serviceuser.application.rest;

import com.saidbouig.serviceuser.domain.ResourceNotFoundException;
import com.saidbouig.serviceuser.domain.User;
import com.saidbouig.serviceuser.domain.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUsersById(@PathVariable(value = "id") Long userId) {
        try {
            User user =
                userService.getById(userId);
            return ResponseEntity.ok().body(user);
        } catch (ResourceNotFoundException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public User createUser(@Valid @RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(
        @PathVariable(value = "id") Long userId, @Valid @RequestBody User userDetails) {
        try {
            final User updatedUser = userService.update(userId, userDetails);
            return ResponseEntity.ok(updatedUser);
        } catch (ResourceNotFoundException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws Exception {
        userService.delete(userId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
