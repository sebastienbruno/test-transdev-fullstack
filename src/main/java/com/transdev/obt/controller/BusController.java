package com.transdev.obt.controller;

import static org.springframework.http.HttpStatus.CREATED;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transdev.obt.domain.Bus;
import com.transdev.obt.dto.BusDto;
import com.transdev.obt.service.BusService;

@RestController
@RequestMapping(value = "/bus", produces = MediaType.APPLICATION_JSON_VALUE)
public class BusController {

    private BusService busService;

    public BusController(final BusService busService) {
        this.busService = busService;
    }

    @GetMapping
    public ResponseEntity<List<BusDto>> findAll() {
        return ResponseEntity.ok(busService.findAll().stream().map(BusDto::fromEntity).collect(Collectors.toList()));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BusDto> create(final @RequestBody BusDto bus) {
        return ResponseEntity.status(CREATED).body(BusDto.fromEntity(busService.create(bus.toEntity())));
    }

    @GetMapping("/{numero}")
    public ResponseEntity<BusDto> findByNumero(@PathVariable int numero) {
        Optional<Bus> bus = busService.findBy(numero);
        if (bus.isPresent()) {
            return ResponseEntity.ok(BusDto.fromEntity(bus.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{numero}")
    public ResponseEntity<Void> deleteBus(@PathVariable int numero) {
        busService.deleteBy(numero);
        return ResponseEntity.noContent().build();
    }
}
