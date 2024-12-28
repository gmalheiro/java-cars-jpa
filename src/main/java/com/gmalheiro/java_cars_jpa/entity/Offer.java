package com.gmalheiro.java_cars_jpa.entity;

import com.gmalheiro.java_cars_jpa.enums.OfferStatus;
import jakarta.persistence.Entity;

import java.time.LocalDateTime;

@Entity(name = "tb_offer")
public class Offer {

    private Long id;

    private Double amount;

    private OfferStatus status;

    private LocalDateTime date;
}
