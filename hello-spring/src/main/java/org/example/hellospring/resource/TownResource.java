package org.example.hellospring.resource;

import org.example.hellospring.domain.Town;
import org.example.hellospring.repository.TownRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/towns")
public class TownResource {
    private final TownRepository townRepository;

    @Autowired
    public TownResource(TownRepository townRepository) {
        this.townRepository = townRepository;
    }

    @GetMapping
    public List<Town> towns() {
        return townRepository.findAll();
    }
}
