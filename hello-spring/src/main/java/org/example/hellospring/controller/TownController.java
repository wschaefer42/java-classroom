package org.example.hellospring.controller;

import org.example.hellospring.repository.TownRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // MVC
@RequestMapping("/towns")
public class TownController {
    private final TownRepository townRepository;

    public TownController(TownRepository townRepository) {
        this.townRepository = townRepository;
    }

    @GetMapping
    public String getTowns(Model model) {
        model.addAttribute("towns", townRepository.findAll());
        return "towns";
    }
}
