package com.transdev.obt.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.transdev.obt.domain.Facture;
import com.transdev.obt.domain.Reservation;
import com.transdev.obt.domain.TypeMoyenPaiementEnum;
import com.transdev.obt.repository.FactureRepository;
import com.transdev.obt.service.FactureService;

@Service
public class FactureServiceImpl implements FactureService {

    private FactureRepository factureRepository;

    public FactureServiceImpl(FactureRepository factureRepository) {
        this.factureRepository = factureRepository;
    }

    @Override
    public Facture generateFacture(Reservation reservation, TypeMoyenPaiementEnum moyenPaiement) {
        Facture facture = Facture.builder().reservation(reservation).typeMoyenPaiementEnum(moyenPaiement).build();
        return factureRepository.save(facture);
    }

    @Override
    public List<Facture> getSortedFactures() {
        return factureRepository.findByOrderByFactureIdAsc();
    }
}
