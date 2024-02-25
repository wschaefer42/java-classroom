package org.example.demojakarta.greeting;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.demojakarta.hello.Fillings;
import java.time.LocalDateTime;
import java.util.List;

@Stateless
public class HelloDao {
    @PersistenceContext
    private EntityManager entityManager;

    public List<HelloEntity> findAll() {
        return entityManager.createQuery("select h from HelloEntity h", HelloEntity.class).getResultList();
    }

    @Transactional
    public HelloEntity save(HelloEntity hello) {
        if (hello.getId() == null) {
            entityManager.persist(hello);
        } else {
            entityManager.merge(hello);
        }
        return hello;
    }

    @Transactional
    public void add(String name, Fillings fillings) {
        entityManager.persist(new HelloEntity() {{
            setName(name);
            setFillings(fillings);
            setCreatedAt(LocalDateTime.now());
        }});
    }

    @Transactional
    public void truncate() {
        entityManager.createNativeQuery("truncate table demo.hellos restart identity")
                .executeUpdate();
    }

    public long count() {
        return entityManager.createQuery("select count(h) from HelloEntity h", Long.class).getSingleResult();
    }
}
