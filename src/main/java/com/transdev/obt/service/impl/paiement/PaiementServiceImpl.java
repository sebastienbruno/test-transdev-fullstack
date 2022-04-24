package com.transdev.obt.service.impl.paiement;

import org.springframework.stereotype.Service;

import com.transdev.obt.domain.Facture;
import com.transdev.obt.domain.Reservation;
import com.transdev.obt.model.MoyenPaiement;
import com.transdev.obt.service.PaiementService;

@Service
public class PaiementServiceImpl implements PaiementService {

    private PaiementFactoryService paiementFactory;

    public PaiementServiceImpl(PaiementFactoryService paiementFactory) {
        this.paiementFactory = paiementFactory;
    }

    @Override
    public Facture payReservation(Reservation reservation, MoyenPaiement moyenPaiement) {
        Paiement paiement = paiementFactory.createPaiementByTypeMoyenPaiement(moyenPaiement.getTypeMoyenPaiement());
        return paiement.payReservation(reservation);
    }
}
