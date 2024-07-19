package com.example.demo.model;
import jakarta.persistence.*;

@Entity
@Table(name = "Tb_restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nameRestaurant")
    private String nameRestaurant;

    private String email;
    private String password;
    private String departament;
    private String province;
    private String district;
    private String address;
    private String kindofood;
    private String phonenumber;
    private String pricerange;
    private String description;


    // Constructors, getters, setters
    // You can generate these using your IDE or manually

    public Restaurant() {
    }

    public Restaurant(Long id, String nameRestaurant, String email, String password, String departament, String province, String district, String address, String kindofood, String phonenumber, String pricerange, String description) {
        this.id = id;
        this.nameRestaurant = nameRestaurant;
        this.email = email;
        this.password = password;
        this.departament = departament;
        this.province = province;
        this.district = district;
        this.address = address;
        this.kindofood = kindofood;
        this.phonenumber = phonenumber;
        this.pricerange = pricerange;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameRestaurant() {
        return nameRestaurant;
    }

    public void setNameRestaurant(String nameRestaurant) {
        this.nameRestaurant = nameRestaurant;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getKindofood() {
        return kindofood;
    }

    public void setKindofood(String kindofood) {
        this.kindofood = kindofood;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPricerange() {
        return pricerange;
    }

    public void setPricerange(String pricerange) {
        this.pricerange = pricerange;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}