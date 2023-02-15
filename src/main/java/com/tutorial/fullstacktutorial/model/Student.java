package com.tutorial.fullstacktutorial.model;


import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// allows mapping to db for personal note
@Entity
public class Student implements Serializable {
    @Id
    // makes IDs as primary keys I think
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // does not allow this field to be null, cannot be changed after creation
    // could also add nullable field to other columns I would think
    @Column(nullable = false, updatable = false)
    private Long id;
    private String firstName;
    private String lastName;
    private String year;
    private String email;
    private String phone;
    private String imgUrl;

    public Student() {}

    public Student(String firstName, String lastName, String year, String email, String phone, String imageUrl) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.year = year;
        this.email = email;
        this.phone = phone;
        this.imgUrl = imageUrl;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getYear() {
        return this.year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    // to make printing the object more readable, if ever need to print out
    @Override
    public String toString() {
        return "Student{" + "id=" + id
                        + ", name=" + firstName + " " + lastName
                        + ", year=" + year
                        + ", email=" + email
                        + ", phone=" + phone
                        + ", imgUrl=" + imgUrl
                        + "}";
    }
}
