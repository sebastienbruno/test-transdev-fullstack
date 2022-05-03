package com.transdev.obt.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.transdev.obt.domain.Billet;
import com.transdev.obt.domain.Reservation;
import com.transdev.obt.exception.NombrePlaceInsuffisantException;
import com.transdev.obt.repository.ReservationRepository;
import com.transdev.obt.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

    private ReservationRepository reservationRepository;

    public ReservationServiceImpl(final ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    @Transactional
    public Reservation create(Reservation reservation) {
        reservation.getBillets().stream().forEach(this::verifierDisponibilitePlace);
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> findBy(Long id) {
        return reservationRepository.findById(id);
    }

    @Override
    public void deleteBy(Long id) {
        reservationRepository.deleteById(id);
    }

    private void verifierDisponibilitePlace(Billet billet) {
        int nbPlaceTotal = billet.getTrajet().getNbrPlace();
        Long nbPlaceReserve = reservationRepository.countNombrePlaceRestante(billet.getTrajet().getTrajetId());
        int nbPlaceDemande = billet.getQuantite();
        int nbPlaceRestante = nbPlaceTotal - (int) nbPlaceReserve.longValue();
        if ( nbPlaceDemande >  nbPlaceRestante) {
            throw new NombrePlaceInsuffisantException(billet.getTrajet().toString(), nbPlaceRestante, billet.getQuantite());
        }
    }
}
