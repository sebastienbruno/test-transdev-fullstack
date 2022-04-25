package com.transdev.obt.service.impl.paiement;

import org.springframework.stereotype.Service;

import com.transdev.obt.domain.Facture;
import com.transdev.obt.domain.Reservation;
import com.transdev.obt.exception.MoyenPaiementNotValidException;
import com.transdev.obt.model.MoyenPaiement;
import com.transdev.obt.service.PaiementService;

@Service
public class PaiementServiceImpl implements PaiementService {

    private PaiementServiceFactory paiementServiceFactory;

    public PaiementServiceImpl(PaiementServiceFactory paiementServiceFactory) {
        this.paiementServiceFactory = paiementServiceFactory;
    }

    @Override
    public Facture payReservation(Reservation reservation, MoyenPaiement moyenPaiement) throws MoyenPaiementNotValidException {
        Paiement paiement = paiementServiceFactory.createPaiementByTypeMoyenPaiement(moyenPaiement.getTypeMoyenPaiement())
            .orElseThrow(() -> new MoyenPaiementNotValidException("Moyen de paiement invalide"));
        return paiement.payReservation(reservation);
    }
}
