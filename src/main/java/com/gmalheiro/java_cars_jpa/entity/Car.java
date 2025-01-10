package com.gmalheiro.java_cars_jpa.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;

    private String brand;

    private int carYear;

    private double price;

    @ManyToOne
    private User user;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "car")
    private List<Offer> offers = new ArrayList<Offer>();


    public Car() {
    }

    public Car(String model, String brand, int carYear, double price, User user) {
        this.model = model;
        this.brand = brand;
        this.carYear = carYear;
        this.price = price;
        this.user = user;
    }

    public Car(String model, String brand, int carYear, double price) {
        this.model = model;
        this.brand = brand;
        this.carYear = carYear;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getCarYear() {
        return carYear;
    }

    public void setCarYear(int carYear) {
        this.carYear = carYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", carYear=" + carYear +
                ", price=" + price +
                ", user=" + user +
                '}';
    }
}
