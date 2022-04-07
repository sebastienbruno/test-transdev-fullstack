package com.transdev.obt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transdev.obt.domain.Facture;

public interface FactureRepository extends JpaRepository<Facture, Long> {

    List<Facture> findByOrderByFactureIdAsc();
}
