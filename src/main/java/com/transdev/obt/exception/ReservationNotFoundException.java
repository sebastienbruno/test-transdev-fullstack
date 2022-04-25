package com.transdev.obt.exception;

public class ReservationNotFoundException extends Exception {

    public ReservationNotFoundException(Long reservationID) {
        super("La réservation avec l'identifiant " + reservationID + " est introuvable.");
    }

    public ReservationNotFoundException(String message) {
        super(message);
    }
}
