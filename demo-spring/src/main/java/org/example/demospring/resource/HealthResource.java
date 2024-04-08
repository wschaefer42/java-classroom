package org.example.demospring.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/health")
public class HealthResource {
    @GetMapping("/ping")
    public String ping() {
        return "PONG";
    }
}
