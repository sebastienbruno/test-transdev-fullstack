package com.transdev.obt.controller;

import static org.springframework.http.HttpStatus.CREATED;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transdev.obt.domain.Client;
import com.transdev.obt.domain.Reservation;
import com.transdev.obt.domain.Trajet;
import com.transdev.obt.dto.CreateReservationDto;
import com.transdev.obt.dto.ReservationDto;
import com.transdev.obt.exception.ClientNotFoundException;
import com.transdev.obt.exception.TrajetNotFoundException;
import com.transdev.obt.service.ClientService;
import com.transdev.obt.service.ReservationService;
import com.transdev.obt.service.TrajetService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "/reservations", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReservationController {

    private ReservationService reservationService;
    private TrajetService trajetService;
    private ClientService clientService;

    public ReservationController(final ReservationService reservationService, 
            final ClientService clientService,
            final TrajetService trajetService) {
        this.reservationService = reservationService;
        this.clientService = clientService;
        this.trajetService = trajetService;
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> findAll() {
        return ResponseEntity.ok(reservationService.findAll());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReservationDto> create(final @RequestBody CreateReservationDto reservation) throws ClientNotFoundException, TrajetNotFoundException {
        if (reservation.getTrajetsId().isEmpty() || Objects.isNull(reservation.getClientId())) {
            throw new IllegalArgumentException();
        }
        List<Trajet> trajets = trajetService.findAllById(reservation.getTrajetsId());
        if (trajets.size() != reservation.getTrajetsId().size()) {
            throw new TrajetNotFoundException();
        }
        Client client = clientService.findById(reservation.getClientId())
            .orElseThrow(() -> new ClientNotFoundException(reservation.getClientId()));
        Reservation reservationToSave = Reservation.builder()
            .client(client)
            .trajets(trajets).build();
        Reservation createdReservation = reservationService.create(reservationToSave);
        return ResponseEntity.status(CREATED).body(ReservationDto.fromEntity(createdReservation));
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
