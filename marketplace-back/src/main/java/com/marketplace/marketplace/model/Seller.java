package com.marketplace.marketplace.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="seller")
public class Seller {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="first_name", nullable = false, length = 60)
    private String name;
    @Column(name="last_name", nullable = false, length = 60)
    private String lastName;
    @Column(name="email", nullable = false, length = 120)
    private String email;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date birthday;


    public Seller() {
    }

    public Seller(Long id, String name, String lastName, String email, Date birthday) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.birthday = birthday;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Seller seller = (Seller) o;
        return Objects.equals(id, seller.id) && Objects.equals(name, seller.name) && Objects.equals(lastName, seller.lastName) && Objects.equals(email, seller.email) && Objects.equals(birthday, seller.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, email, birthday);
    }
}
