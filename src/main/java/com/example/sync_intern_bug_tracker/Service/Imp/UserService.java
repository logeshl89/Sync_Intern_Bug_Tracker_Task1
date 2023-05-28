package com.example.sync_intern_bug_tracker.Service.Imp;

import com.example.sync_intern_bug_tracker.Entity.User;

import java.util.Optional;

public interface UserService {

    User findByUsername(String username);

    Optional<User> getUserById(Long userId);
}

