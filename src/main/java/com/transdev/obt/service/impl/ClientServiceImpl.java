package com.transdev.obt.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.transdev.obt.domain.Client;
import com.transdev.obt.repository.ClientRepository;
import com.transdev.obt.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    public ClientServiceImpl(final ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Optional<Client> findById(Long clientId) {
        return clientRepository.findById(clientId);
    }
}
