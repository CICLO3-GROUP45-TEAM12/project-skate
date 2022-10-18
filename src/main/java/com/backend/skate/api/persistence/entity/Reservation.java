package com.backend.skate.api.persistence.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReservation;
    @Column()
    private Date startDate;
    @Column
    private Date devolutionDate;
    @Column
    private String status = "created";

    @ManyToOne
    @JoinColumn(name = "skate")
    @JsonIgnoreProperties("reservations")
    private Skate skate;

    @ManyToOne
    @JoinColumn(name = "client")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Client client;

    @OneToOne(mappedBy = "reservation", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("reservation")
    private Score score;

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Skate getSkate() {
        return skate;
    }

    public void setSkate(Skate skate) {
        this.skate = skate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}
