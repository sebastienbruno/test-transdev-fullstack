package com.transdev.obt.service.impl.paiement;

import org.springframework.stereotype.Service;

import com.transdev.obt.domain.Facture;
import com.transdev.obt.domain.Reservation;
import com.transdev.obt.domain.TypeMoyenPaiementEnum;
import com.transdev.obt.service.FactureService;

@Service
public class PaiementByCard implements Paiement {

    private FactureService factureService;

    public PaiementByCard(FactureService factureService) {
        this.factureService = factureService;
    }

    public Facture payReservation(Reservation reservation) {
        return factureService.generateFacture(reservation, TypeMoyenPaiementEnum.CARTE_BANCAIRE);
    }
}
