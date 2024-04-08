package org.example.demospring.domain.repository;

import org.example.demospring.domain.Greeting;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface GreetingRepository extends CrudRepository<Greeting, Long> {
    @NonNull
    List<Greeting> findAll();
    List<Greeting> findAllByFormality(Greeting.Formality formality);
    Optional<Greeting> findByLangAndFormality(String lang, Greeting.Formality formality);
}
