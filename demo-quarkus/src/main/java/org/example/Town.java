package org.example;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "towns")
public class Town {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @NotBlank
    public String name;
    @NotBlank @Size(max = 3)
    public String countryCode;
}
