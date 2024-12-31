package com.gmalheiro.java_cars_jpa.entity;

import com.gmalheiro.java_cars_jpa.enums.OfferStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "tb_offer")
@NoArgsConstructor
@AllArgsConstructor
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    private OfferStatus status;

    private LocalDateTime date;

    @ManyToOne
    private User user;
}
