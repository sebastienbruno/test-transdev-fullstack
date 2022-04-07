package com.transdev.obt.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
public class Trajet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trajetId;

    @Column
    private int nbrPlace;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateDepart;

    @Column
    private float prix;

    @OneToOne
    @JoinColumn(name = "bus_id_fk")
    private Bus bus;

    @ManyToOne
    @JoinColumn(name = "reservation_id_fk")
    private Reservation reservation;
}
