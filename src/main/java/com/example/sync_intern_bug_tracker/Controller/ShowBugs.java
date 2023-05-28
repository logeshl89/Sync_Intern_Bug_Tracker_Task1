package com.example.sync_intern_bug_tracker.Controller;

import com.example.sync_intern_bug_tracker.Entity.Bug;
import com.example.sync_intern_bug_tracker.Service.BugServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ShowBugs {
    private final BugServiceImpl bugService;

    public ShowBugs(BugServiceImpl bugService) {
        this.bugService = bugService;
    }

    @GetMapping("/auth/ShowAllTheBugs")
    String getAllTheBugs(Model model)
    {
        List<Bug> allTheBugs = bugService.getAllTheBugs();
        model.addAttribute("bugs",allTheBugs);
        System.out.println(allTheBugs);
        System.out.println("The Show all the bugs is called");
        return "ShowBugs";
    }
    @RequestMapping("/Update/{id}")
    String SetUpdate(@PathVariable("id") Long id,Model model)
    {
        bugService.UpdateTheStatus(id);
        List<Bug> allTheBugs = bugService.getAllTheBugs();
        model.addAttribute("bugs",allTheBugs);
        System.out.println("Update is called");
        System.out.println(id);
        return "ShowBugs";
    }
    @RequestMapping("/FixedBugs")
    String GetFixedBug(Model model)
    {
        model.addAttribute("bugs",bugService.GetCompletedBugs());
        return "FixedBugs";
    }
}
