package org.example.hellospring.controller;

import org.example.hellospring.service.AddressService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/addresses")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("addresses", addressService.findAll());
        model.addAttribute("title", "Addresses");
        return "addresses";
    }
}
