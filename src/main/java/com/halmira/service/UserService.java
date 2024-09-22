package com.halmira.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.halmira.repository.UserRepository;
import com.halmira.model.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void lockUserProfile(Long userId, boolean visibility) {
        User user = getUserById(userId);
        if (user != null) {
            user.setProfileLock(visibility);
            userRepository.save(user);
        }
    }
}

