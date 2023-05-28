package com.example.sync_intern_bug_tracker.Service;

import com.example.sync_intern_bug_tracker.Entity.User;
import com.example.sync_intern_bug_tracker.Repository.UserRepository;
import com.example.sync_intern_bug_tracker.Service.Imp.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Autowired
    private final PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public String encryptText(String text) {
        return bCryptPasswordEncoder.encode(text);
    }

    public User login(String username, String password) {
        User byUsername = userRepository.findByUsername(username.trim());
        if (byUsername == null) {
            return null;
        } else if (username.equals(byUsername.getUsername()) && bCryptPasswordEncoder.matches(password, byUsername.getPassword())) {
            System.out.println("you are the user");
            return byUsername;
        }
        System.out.println(byUsername);
        return null;
    }
}

