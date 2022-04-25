package com.transdev.obt.service;

import com.transdev.obt.domain.Facture;
import com.transdev.obt.domain.Reservation;
import com.transdev.obt.exception.MoyenPaiementNotValidException;
import com.transdev.obt.model.MoyenPaiement;

public interface PaiementService {

    /**
     * @param reservation
     * @return
     * @throws MoyenPaiementNotValidException
     */
    Facture payReservation(Reservation reservation, MoyenPaiement moyenPaiement) throws MoyenPaiementNotValidException;
}
