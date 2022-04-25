package com.transdev.obt.controller;

import com.transdev.obt.dto.FactureDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transdev.obt.domain.Facture;
import com.transdev.obt.domain.Reservation;
import com.transdev.obt.exception.MoyenPaiementNotValidException;
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
  public ResponseEntity<FactureDto> payReservation(final @RequestBody Long reservationId, MoyenPaiement moyenPaiement) throws MoyenPaiementNotValidException, ReservationNotFoundException {
    Reservation reservation = reservationService.findBy(reservationId)
      .orElseThrow(() -> new ReservationNotFoundException(reservationId));
    Facture facture = paiementService.payReservation(reservation, moyenPaiement);
    return ResponseEntity.ok(FactureDto.fromEntity(facture));
  }
}
