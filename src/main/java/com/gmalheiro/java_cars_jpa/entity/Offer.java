package com.gmalheiro.java_cars_jpa.entity;

import com.gmalheiro.java_cars_jpa.enums.OfferStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "tb_offer")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    private OfferStatus status;

    private LocalDateTime date;

    @ManyToOne
    private User user;

    @ManyToOne
    private Car car;

    public Offer() {
    }

    public Offer(Double amount, OfferStatus status, LocalDateTime date) {
        this.amount = amount;
        this.status = status;
        this.date = date;
    }

    public Offer(User user, LocalDateTime date, OfferStatus status, Double amount,Car car) {
        this.user = user;
        this.car = car;
        this.date = date;
        this.status = status;
        this.amount = amount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public OfferStatus getStatus() {
        return status;
    }

    public void setStatus(OfferStatus status) {
        this.status = status;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
