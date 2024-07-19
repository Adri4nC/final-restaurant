package com.example.demo.model;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Tb_review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeReview;

    @Column
    private String codeBooking;
    private int quialification;
    private String comment;
    private Date date;

    // Constructors, getters, setters
    // You can generate these using your IDE or manually


    public Review() {
    }

    public Review(Long codeReview, String codeBooking, int quialification, String comment, Date date) {
        this.codeReview = codeReview;
        this.codeBooking = codeBooking;
        this.quialification = quialification;
        this.comment = comment;
        this.date = date;
    }

    public String getCodeBooking() {
        return codeBooking;
    }

    public void setCodeBooking(String codeBooking) {
        this.codeBooking = codeBooking;
    }

    public Long getCodeReview() {
        return codeReview;
    }

    public void setCodeReview(Long codeReview) {
        this.codeReview = codeReview;
    }

    public int getQuialification() {
        return quialification;
    }

    public void setQuialification(int quialification) {
        this.quialification = quialification;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}