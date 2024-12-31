package com.gmalheiro.java_cars_jpa.entity;

import com.gmalheiro.java_cars_jpa.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "tb_user")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    private String email;

    @OneToMany
    private List<Car> cars = new ArrayList<Car>();

    @OneToMany(mappedBy = "user")
    private List<Offer> offers = new ArrayList<Offer>();
}
