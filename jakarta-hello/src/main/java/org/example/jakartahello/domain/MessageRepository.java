package org.example.jakartahello.domain;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Stateless
public class MessageRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Message> findAll() {
        return entityManager.createQuery("select m from Message m", Message.class).getResultList();
    }

    public Message findById(long id) {
        return entityManager.find(Message.class, id);
    }

    @Transactional
    @SuppressWarnings("all")
    public Message save(Message message) {
        if (message.getId() == null) {
            if (message.getCreatedAt() == null) {
                message.setCreatedAt(LocalDateTime.now());
            }
            entityManager.persist(message);
        } else {
            entityManager.merge(message);
        }
        return message;
    }

    @Transactional
    public void add(String name, Fillings fillings) {
        entityManager.persist(new Message() {{
            setName(name);
            setFillings(fillings);
            setCreatedAt(LocalDateTime.now());
        }});
    }

    @Transactional
    public boolean delete(long id) {
        Message message = findById(id);
        if (message != null) {
            entityManager.remove(message);
            return true;
        }
        return false;
    }

    @Transactional
    public void truncate() {
        entityManager.createNativeQuery("truncate table demo.messages restart identity")
                .executeUpdate();
    }

    public long count() {
        return entityManager.createQuery("select count(m) from Message m", Long.class).getSingleResult();
    }
}
