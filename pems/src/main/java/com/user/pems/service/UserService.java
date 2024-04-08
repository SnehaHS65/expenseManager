package com.user.pems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.pems.dto.User;
import com.user.pems.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByUsername(String username) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        return userOptional.orElse(null);
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User updateUserByUsername(String username, User user) {
        User existingUser = getUserByUsername(username);
        if (existingUser != null) {
            // Update the fields of existingUser with the fields of the passed user object
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            existingUser.setDateJoined(user.getDateJoined());
            existingUser.setAccounts(user.getAccounts());
            existingUser.setExpenses(user.getExpenses());
            existingUser.setLoans(user.getLoans());
            
            return userRepository.save(existingUser);
        }
        return null;
    }

    public void deleteUserByUsername(String username) {
        User userToDelete = getUserByUsername(username);
        if (userToDelete != null) {
            userRepository.delete(userToDelete);
        }
    }
}
