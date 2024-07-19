package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Tb_booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int idUser;
    private int idRestaurant;
    private String date;
    private String time;
    private int numPeople;

    // Constructors, getters, setters
    // You can generate these using your IDE or manually

    public Booking() {
    }

    public Booking(int idUser, int idRestaurant, String date, String time, int numPeople) {
        this.idUser = idUser;
        this.idRestaurant = idRestaurant;
        this.date = date;
        this.time = time;
        this.numPeople = numPeople;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public int getidUser() {
        return idUser;
    }


    public void setidUser(int idUser) {
        this.idUser = idUser;
    }

    public int getidRestaurant() {
        return idRestaurant;
    }

    public void setidRestaurant(int idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    public String getdate() {
        return date;
    }

    public void setdate(String date) {
        this.date = date;
    }

    public String gettime() {
        return time;
    }

    public void settime(String time) {
        this.time = time;
    }

    public int getnumPeople() {
        return numPeople;
    }

    public void setnumPeople(int numPeople) {
        this.numPeople = numPeople;
    }
}