package com.example.sync_intern_bug_tracker.Repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BugRepositoryTest {
private BugRepository bugRepository;

    BugRepositoryTest(BugRepository bugRepository) {
        this.bugRepository = bugRepository;
    }

    @Test
    public void Test()
{
    bugRepository.updateById(2);
}
}