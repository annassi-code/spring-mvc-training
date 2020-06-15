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
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class LoginController {

        @Autowired
    UserRepository userRepository;

    @GetMapping("/login/add/")
    public String getAddUserForm(@ModelAttribute("userObject") User  user, Model model) {
        return "login";
    }

    @PostMapping("/login/add/")
    public String addUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        System.out.println(user);
        new UserValidator(user.getConfirmPassword()).validate(user, result);
        if (result.hasErrors()) {
            return "new-user";
        } else {
            userRepository.save(user);
        }
        model.addAttribute("message", "a new usre has been created");
        return "redirect:/users/";
    }


}
