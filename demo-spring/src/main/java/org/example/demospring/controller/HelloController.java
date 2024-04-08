package org.example.demospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello(
            Model model,
            @RequestParam(defaultValue = "Hello") String greeting,
            @RequestParam(defaultValue = "Nobody") String name) {
        model.addAttribute("title", "Greeting");
        model.addAttribute("greeting", greeting);
        model.addAttribute("name", name);
        return "hello";
    }
}
