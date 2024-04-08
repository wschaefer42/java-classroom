package org.example.hellospring.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "towns")
@Getter @Setter @NoArgsConstructor
public class Town {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @Column(nullable = false, unique = true, length = 50)
    private String name;
    @NotBlank
    private String countryCode = "CHE";
    @OneToMany
    private Set<Address> addresses = new HashSet<Address>();

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode.toUpperCase();
    }

    public Town(@NotBlank String name, @NotBlank String countryCode) {
        this.name = name;
        this.countryCode = countryCode.toUpperCase();
    }
}
