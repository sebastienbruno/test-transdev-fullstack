package com.transdev.obt.service;

import java.util.Optional;

import com.transdev.obt.domain.Client;

public interface ClientService {

    /**
     * @param clientId
     * @return Client par son id
     */
    Optional<Client> findById(Long clientId);
}
