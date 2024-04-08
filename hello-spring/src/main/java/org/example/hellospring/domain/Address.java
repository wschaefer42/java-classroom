package org.example.hellospring.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "addresses")
@Getter @Setter @ToString @NoArgsConstructor
public class Address {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String street;
    @NotBlank
    private String houseNumber;
    @ManyToOne
    private Town town;

    public Address(String street, String houseNumber, Town town) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.town = town;
    }
}
