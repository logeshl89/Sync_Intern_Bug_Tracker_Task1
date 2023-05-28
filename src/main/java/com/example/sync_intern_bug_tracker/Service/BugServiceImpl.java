package com.example.sync_intern_bug_tracker.Service;

import com.example.sync_intern_bug_tracker.Entity.Bug;
import com.example.sync_intern_bug_tracker.Entity.User;
import com.example.sync_intern_bug_tracker.Repository.BugRepository;
import com.example.sync_intern_bug_tracker.Service.Imp.BugService;
import com.example.sync_intern_bug_tracker.Service.Imp.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BugServiceImpl implements BugService {

    private final BugRepository bugRepository;

    private final UserService userService;

    public BugServiceImpl(BugRepository bugRepository, UserService userService) {
        this.bugRepository = bugRepository;
        this.userService = userService;
    }

    @Override
    public void addBug(Bug bug, Long userId) {
        Optional<User> user = userService.getUserById(userId);
        System.out.println("The Bug in the Service layer is : " + bug);
        bugRepository.save(bug);
    }

    public void UpdateTheStatus(long id) {
        long l = bugRepository.updateById(id);
        System.out.println(l);
    }

    @Override
    public List<Bug> getAllTheBugs() {
        return bugRepository.findAll().stream().filter(e -> !Objects.equals(e.getStatus(), "Resolved")).toList();
    }

    public List<Bug> GetCompletedBugs() {
        return bugRepository.findAll().stream().filter(e -> Objects.equals(e.getStatus(), "Resolved")).toList();
    }
}

