package com.application.controller;

import com.application.entity.User;
import com.application.repository.UserRepository;
import com.application.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "users";
    }
    @GetMapping("/users/add/")
    public String getAddUserForm(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("action", "add");
        return "new-user";
    }

    @PostMapping("/users/add/")
    public String addUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        new UserValidator(user.getConfirmPassword()).validate(user, result);
        if (result.hasErrors()) {
            return "new-user";
        }
        userRepository.save(user);
        model.addAttribute("message", "a new user has been added");
        return "redirect:/users/";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable String id, Model model) {
        userRepository.deleteById(id);
        model.addAttribute("message", "user " + id + " has been removed");
        return "redirect:/users";
    }

    @GetMapping("/users/modify/{userId}")
    public String modifyUser(@PathVariable String userId, Model model) {
        model.addAttribute("user", userRepository.findById(userId));
        model.addAttribute("action", "update");
        return "new-user";
    }

    @PostMapping("/users/modify/{userId}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable String userId, Model model) {
        user.setUsername(userId);
        if (user.getUsername() != null) {
            userRepository.save(user);
        }
        model.addAttribute("message", "user " + user.getUsername() + " has been updated");
        return "redirect:/users";
    }
}
