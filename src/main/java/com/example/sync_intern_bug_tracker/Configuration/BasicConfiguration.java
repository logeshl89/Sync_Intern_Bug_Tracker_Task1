package com.example.sync_intern_bug_tracker.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BasicConfiguration {
    @Bean
public PasswordEncoder getPasswordEncoder(){
    return new BCryptPasswordEncoder();
}
}
