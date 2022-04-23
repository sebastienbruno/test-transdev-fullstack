package com.transdev.obt.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.transdev.obt.domain.Reservation;
import com.transdev.obt.repository.ReservationRepository;
import com.transdev.obt.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

    private ReservationRepository reservationRepository;

    public ReservationServiceImpl(final ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Reservation create(Reservation reservation) {
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
}
