package com.example.sync_intern_bug_tracker.Controller;

import com.example.sync_intern_bug_tracker.Entity.Bug;
import com.example.sync_intern_bug_tracker.Service.BugServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddNewBug {
    private final BugServiceImpl bugService;

    public AddNewBug(BugServiceImpl bugService) {
        this.bugService = bugService;
    }

    @GetMapping("auth/bugs/add")
    public String getThePage()
    {
        System.out.println("The Add Get method is called");
        return "AddTheNewBug";
    }

    @PostMapping("auth/bugs/add/post")
    public String PostTheData(@ModelAttribute Bug bug)
    {
        System.out.println("The Add post method is called");
        System.out.println(bug);
        bugService.addBug(bug,LoginController.id);
        return "redirect:/auth/ShowAllTheBugs";
    }
}