package com.example.sync_intern_bug_tracker.Repository;

import com.example.sync_intern_bug_tracker.Entity.Bug;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
public interface BugRepository extends JpaRepository<Bug,Long> {
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE bugs SET status='Resolved' WHERE id=?1")
    int updateById(long id);

}
