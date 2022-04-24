package com.transdev.obt.controller;

import static org.springframework.http.HttpStatus.CREATED;

import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transdev.obt.domain.Reservation;
import com.transdev.obt.service.ReservationService;

@RestController
@RequestMapping(value = "/reservations", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReservationController {

    private ReservationService reservationService;

    public ReservationController(final ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> findAll() {
        return ResponseEntity.ok(reservationService.findAll());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reservation> create(final @RequestBody Reservation reservation) {
        Reservation createdReservation = reservationService.create(reservation);
        return ResponseEntity.status(CREATED).body(createdReservation);
    }

    @GetMapping("{id}")
    public ResponseEntity<Reservation> findByNumero(@PathVariable Long id) {
        Optional<Reservation> reservation = reservationService.findBy(id);
        if (reservation.isPresent()) {
            return ResponseEntity.ok(reservation.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteBus(@PathVariable Long id) {
        reservationService.deleteBy(id);
        return ResponseEntity.noContent().build();
    }
}
