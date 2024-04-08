package org.example.hellospring.repository;

import org.example.hellospring.domain.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TownRepository extends JpaRepository<Town, Long> {
    List<Town> findAllByName(String name);
    Optional<Town> findByNameAndCountryCode(String name, String countryCode);
    Town findByNameAndCountryCodeIgnoreCase(String name, String countryCode);
}
