package com.gmalheiro.java_cars_jpa.entity;

import com.gmalheiro.java_cars_jpa.enums.Role;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQuery(name = "TbUser.findByUserName", query = "SELECT u FROM User u WHERE u.name=:name")
@NamedQuery(name = "TbUser.findAllUsers", query = "SELECT u FROM User u")
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Car> cars = new ArrayList<Car>();

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Offer> offers = new ArrayList<Offer>();

    public User() {
    }

    public User (UserBuilder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.role = builder.role;
        this.address = builder.address;
        this.cars = builder.cars;
        this.offers = builder.offers;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void addOffer(Offer offer) {
        this.offers.add(offer);
    }

    public void removeOffer(Offer offer) {
        this.offers.remove(offer);
    }

    public void addCar(Car car) {
        this.cars.add(car);
    }

    public void removeCar(Car car) {
        this.cars.remove(car);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role=" + role +
                ", email='" + email + '\'' +
                ", cars=" + cars +
                ", offers=" + offers +
                '}';
    }

    public static class UserBuilder {
        private String name;
        private String email;
        private Role role;
        private Address address;
        private List<Car> cars = new ArrayList<Car>();
        private List<Offer> offers = new ArrayList<Offer>();

        public UserBuilder (String name, String email, Role role) {
            this.name = name;
            this.email = email;
            this.role = role;
        }
        public UserBuilder setCars (List<Car> cars) {
            this.cars = cars;
            return  this;
        }
        public UserBuilder setCar (Car car) {
            this.cars.add(car);
            return  this;
        }

        public UserBuilder setOffer (Offer offer) {
            this.offers.add(offer);
            return  this;
        }

        public UserBuilder setAddress (Address address) {
            this.address = address;
            return this;
        }

        public User build () {
            return new User(this);
        }
    }

}
