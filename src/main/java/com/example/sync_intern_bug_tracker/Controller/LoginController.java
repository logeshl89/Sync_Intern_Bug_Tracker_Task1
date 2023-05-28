package com.example.sync_intern_bug_tracker.Controller;

import com.example.sync_intern_bug_tracker.Entity.User;
import com.example.sync_intern_bug_tracker.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class LoginController {
    static long id;
    @GetMapping("/")
    public String BaseLogin()
    {
        return "Login";
    }
    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "Login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("user") User user, Model model) {
        User loggedInUser = userServiceImpl.login(user.getUsername(), user.getPassword());
        if (loggedInUser != null) {
            id=loggedInUser.getId();
            return "redirect:/auth/ShowAllTheBugs";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "Login";
        }
    }

}

