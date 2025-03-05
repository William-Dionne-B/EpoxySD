package com.firstappWilly.demo;

import com.firstappWilly.demo.User.User;
import com.firstappWilly.demo.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    // Home page
    @GetMapping("/")
    public String home() {
        return "index";
    }

    // Error page (if needed)
    @GetMapping("/error")
    public String error() {
        return "error";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }


    // Users page: Fetch users from database and display them
    @GetMapping("/users")
    public String users(Model model) {
        Iterable<User> users = userRepository.findAll();  // Fetch all users from the database
        model.addAttribute("users", users);  // Add the users list to the model
        return "users";  // Return the users.html template
    }

    // Add new user: Save user to database
    @PostMapping("/addUser")
    public String addUser(@ModelAttribute User user) {
//        String hashedPassword = passwordEncoder.encode(user.getPassword());
//        user.setPassword(hashedPassword);

        userRepository.save(user);  // Save the user

        // Log the user details for debugging

        return "redirect:/users";  // Redirect to the users page to see the updated list
    }

}
