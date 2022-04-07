package com.transdev.obt.service;

import java.util.List;

import com.transdev.obt.domain.Facture;
import com.transdev.obt.domain.Reservation;
import com.transdev.obt.domain.TypeMoyenPaiementEnum;

public interface FactureService {

    Facture generateFacture(Reservation reservation, TypeMoyenPaiementEnum moyenPaiement);

    List<Facture> getSortedFactures();
}
