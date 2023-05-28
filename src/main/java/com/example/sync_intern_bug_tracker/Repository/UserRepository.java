package com.example.sync_intern_bug_tracker.Repository;

import com.example.sync_intern_bug_tracker.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByUsernameAndPassword(String Username, String Password);
}
