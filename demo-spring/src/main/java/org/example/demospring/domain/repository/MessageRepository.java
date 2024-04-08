package org.example.demospring.domain.repository;

import jakarta.transaction.Transactional;
import org.example.demospring.domain.Fillings;
import org.example.demospring.domain.Message;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {
    @NonNull
    List<Message> findAll();
    Message findByName(String name);
    @Modifying
    @Transactional
    @Query(value = "truncate table demo.messages restart identity", nativeQuery = true)
    void truncateTable();
    @Transactional
    @Modifying
    @Query("update Message set fillings = ?2 where id = ?1")
    void updateFillingsById(long id, Fillings fillings);
}
