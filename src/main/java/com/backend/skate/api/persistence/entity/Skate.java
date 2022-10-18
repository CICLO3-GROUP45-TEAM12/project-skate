package com.backend.skate.api.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "skates")
public class Skate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45)
    private String brand;

    @Column(length = 4)
    private Integer year;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(length = 45)
    private String name;

    @Column(length = 250)
    private String description;


    @ManyToOne
    @JoinColumn(name = "category", referencedColumnName = "id")
    @JsonIgnoreProperties("skates")
    private Category category;

    @OneToMany(mappedBy = "skate", cascade = {CascadeType.PERSIST})
    @JsonIgnoreProperties({"skate", "client"})
    private List<Message> messages;

    @OneToMany(mappedBy = "skate", cascade = {CascadeType.PERSIST})
    @JsonIgnoreProperties({"skate", "messages"})
    private List<Reservation> reservations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
