package com.transdev.obt.service.impl.paiement;

import com.transdev.obt.domain.Facture;
import com.transdev.obt.domain.Reservation;

public interface Paiement {

    public Facture payReservation(Reservation reservation);
    
}
