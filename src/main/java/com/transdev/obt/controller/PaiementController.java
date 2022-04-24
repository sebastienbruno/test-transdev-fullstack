package com.transdev.obt.controller;

import com.transdev.obt.dto.FactureDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import com.transdev.obt.domain.Facture;
import com.transdev.obt.domain.Reservation;
import com.transdev.obt.exception.ReservationNotFoundException;
import com.transdev.obt.model.MoyenPaiement;
import com.transdev.obt.service.PaiementService;
import com.transdev.obt.service.ReservationService;

@RestController
@RequestMapping(value = "/paiements", produces = MediaType.APPLICATION_JSON_VALUE)
public class PaiementController {


  private ReservationService reservationService;
  private PaiementService paiementService;

  public PaiementController(ReservationService reservationService, PaiementService paiementService) {
    this.reservationService = reservationService;
    this.paiementService = paiementService;
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<FactureDto> payReservation(final @RequestBody Long reservationId, MoyenPaiement moyenPaiement) {
    Optional<Reservation> reservation = reservationService.findBy(reservationId);
    if (reservation.isPresent()) {
      Facture facture = paiementService.payReservation(reservation.get(), moyenPaiement);
      return ResponseEntity.ok(FactureDto.fromEntity(facture));
    }
    else {
      return ResponseEntity.notFound().build();
    }
  }
}
