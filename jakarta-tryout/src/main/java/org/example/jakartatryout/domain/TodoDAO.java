package org.example.jakartatryout.domain;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class TodoDAO {
    @PersistenceContext(unitName = "samples")
    private EntityManager em;

    public List<Todo> findAll() {
        return em.createQuery("select t from Todo t order by t.name", Todo.class)
                .getResultList();
    }

    public Todo findByName(String name) {
        return em.createQuery("select t from Todo t where t.name = :name", Todo.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    public int count() {
        return (int)em.createQuery("select count(t) from Todo t").getSingleResult();
    }

    public void save(String name, String description) {
        var todo = findByName(name);
        if (todo == null) {
            em.persist(Todo.of(name, description));
        } else {
            todo.setDescription(description);
            em.merge(todo);
        }
    }
}
