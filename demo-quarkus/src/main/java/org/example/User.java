package org.example;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import java.util.List;

/**
 * ActiveRecord pattern Google description by Martin Fowler
 *
 * JPA -> Hibernate ORM -> JDBC (H2)
 */

@Entity
@Table(name = "users")
public class User extends PanacheEntity {
    @NotBlank
    public String name;
    @Email
    public String email;
    @Range(min = 18, max = 65)
    public Integer age;

    public static List<User> findByName(String name) {
        return find("name", name).list();
    }

    public static List<User> findByAge(Integer age) {
        return find("age", age).list();
    }
}
