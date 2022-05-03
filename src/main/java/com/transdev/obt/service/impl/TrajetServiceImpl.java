package com.transdev.obt.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.transdev.obt.domain.Trajet;
import com.transdev.obt.repository.TrajetRepository;
import com.transdev.obt.service.TrajetService;

@Service
public class TrajetServiceImpl implements TrajetService {

    private TrajetRepository trajetRepository;

    public TrajetServiceImpl(final TrajetRepository trajetRepository) {
        this.trajetRepository = trajetRepository;
    }

    @Override
    public Optional<Trajet> findById(Long trajetId) {
        return trajetRepository.findById(trajetId);
    }

    @Override
    public List<Trajet> findAllByNumeroBus(int numeroBus) {
        return trajetRepository.findAllByNumeroBus(numeroBus);
    }

    @Override
    public List<Trajet> findAllByBusId(int busId) {
        return trajetRepository.findAllByBusId(busId);
    }

    @Override
    public List<Trajet> findAllById(Iterable<Long> trajetsId) {
        return trajetRepository.findAllById(trajetsId);
    }
}
