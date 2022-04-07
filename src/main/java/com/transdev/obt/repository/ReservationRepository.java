package com.transdev.obt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transdev.obt.domain.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
