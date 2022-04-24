package com.transdev.obt.service.impl.paiement;

import com.transdev.obt.domain.TypeMoyenPaiementEnum;
import com.transdev.obt.model.MoyenPaiement;
import com.transdev.obt.service.FactureService;

import org.springframework.stereotype.Service;

@Service
public class PaiementFactoryService {
    
    private FactureService factureService;

    public PaiementFactoryService (FactureService factureService) {
        this.factureService = factureService;
    }
    
    public Paiement createPaiementByTypeMoyenPaiement (TypeMoyenPaiementEnum typeMoyenPaiement) {
        switch (typeMoyenPaiement) {
            case CARTE_BANCAIRE :
                return new PaiementByCard(factureService);
            case PAYPAL :
                return new PaiementByPaypal(factureService);
    }
}
