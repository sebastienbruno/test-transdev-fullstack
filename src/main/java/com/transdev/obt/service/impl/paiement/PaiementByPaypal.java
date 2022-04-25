package com.transdev.obt.service.impl.paiement;

import org.springframework.stereotype.Service;

import com.transdev.obt.domain.Facture;
import com.transdev.obt.domain.Reservation;
import com.transdev.obt.domain.TypeMoyenPaiementEnum;
import com.transdev.obt.service.FactureService;

@Service
public class PaiementByPaypal implements Paiement {

    private FactureService factureService;

    public PaiementByPaypal(FactureService factureService) {
        this.factureService = factureService;
    }

    public Facture payReservation(Reservation reservation) {
        return factureService.generateFacture(reservation, TypeMoyenPaiementEnum.PAYPAL);
    }
}
