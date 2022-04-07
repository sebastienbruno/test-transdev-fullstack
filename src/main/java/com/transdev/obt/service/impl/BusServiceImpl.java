package com.transdev.obt.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.transdev.obt.domain.Bus;
import com.transdev.obt.repository.BusRepository;
import com.transdev.obt.service.BusService;

@Service
public class BusServiceImpl implements BusService {

    private BusRepository busRepository;

    public BusServiceImpl(final BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    @Override
    public Bus create(Bus bus) {
        return busRepository.save(bus);
    }

    @Override
    public List<Bus> findAll() {
        return busRepository.findAll();
    }

    @Override
    public Optional<Bus> findBy(int numeroBus) {
        return busRepository.findByNumeroBus(numeroBus);
    }

    @Override
    public void deleteBy(int numeroBus) {
        busRepository.deleteBusByNumeroBus(numeroBus);
    }
}
