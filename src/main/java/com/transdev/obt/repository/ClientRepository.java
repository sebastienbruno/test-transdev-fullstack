package com.transdev.obt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transdev.obt.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
