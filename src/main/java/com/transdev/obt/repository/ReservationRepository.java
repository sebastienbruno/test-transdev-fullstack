package com.transdev.obt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.transdev.obt.domain.Reservation;
import com.transdev.obt.domain.Trajet;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query(value = "SELECT ISNULL(SUM(b.quantite), 0) FROM billet b " +
    "WHERE b.trajet_id_fk = :trajetId", nativeQuery = true)
    Long countNombrePlaceRestante(Long trajetId);
}
