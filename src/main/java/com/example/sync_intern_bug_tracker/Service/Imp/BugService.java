package com.example.sync_intern_bug_tracker.Service.Imp;

import com.example.sync_intern_bug_tracker.Entity.Bug;

import java.util.List;

public interface BugService {
    void addBug(Bug bug, Long userId);
    List<Bug> getAllTheBugs();

}
