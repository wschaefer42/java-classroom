package org.example.demospring.controller;

import jakarta.inject.Inject;
import org.example.demospring.common.Log;
import org.example.demospring.domain.dto.GreetingRecord;
import org.example.demospring.service.GreetingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/greetings")
public class GreetingController {
    private final GreetingService service;

    public record GreetingModel(String lang, String name) {}

    @Inject
    public GreetingController(GreetingService service) {
        this.service = service;
    }

    @GetMapping
    public String hello(Model model) {
        model.addAttribute("title", "Greeting");
        model.addAttribute("greetings", service.getAll());
        return "greeting";
    }

    @GetMapping("/hello")
    public RedirectView sayHello(@ModelAttribute GreetingModel model, RedirectAttributes attributes) {
        GreetingRecord greeting = service.getByLang(model.lang);
        Log.info("Say %s to %s", greeting.text(), model.name);
        attributes.addAttribute("greeting", greeting.text());
        attributes.addAttribute("name", model.name);
        return new RedirectView("/hello");
    }
}
