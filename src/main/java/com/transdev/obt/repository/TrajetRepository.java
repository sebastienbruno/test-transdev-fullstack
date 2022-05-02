package com.transdev.obt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.transdev.obt.domain.Trajet;

public interface TrajetRepository extends JpaRepository<Trajet, Long> {

    @Query("SELECT t FROM Trajet t " +
        "LEFT JOIN t.bus b " +
        "WHERE b.numeroBus = :numeroBus")
    List<Trajet> findAllByNumeroBus(int numeroBus);

    @Query("SELECT t FROM Trajet t " +
        "LEFT JOIN t.bus b " +
        "WHERE b.busId = :busId")
    List<Trajet> findAllByBusId(int busId);
}
