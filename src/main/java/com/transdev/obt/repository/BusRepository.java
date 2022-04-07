package com.transdev.obt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transdev.obt.domain.Bus;

public interface BusRepository extends JpaRepository<Bus, Long> {

    Optional<Bus> findByNumeroBus(int numeroBus);

    void deleteBusByNumeroBus(int numeroBus);
}
