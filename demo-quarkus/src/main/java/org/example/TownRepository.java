package org.example;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class TownRepository implements PanacheRepository<Town> {
    public List<Town> findByName(String name) {
        return find("name", name).list();
    }
}
