package com.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String getHomePage(@RequestParam(required = false, defaultValue = "Alae") String username, Model model) {
        model.addAttribute("username", username);
        return "home";
    }
}
