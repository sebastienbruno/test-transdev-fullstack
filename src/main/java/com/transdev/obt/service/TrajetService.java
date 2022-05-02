package com.transdev.obt.service;

import java.util.List;

import com.transdev.obt.domain.Trajet;

public interface TrajetService {

    /**
     * @param numeroBus
     * @return la liste des Trajets par numero de Bus
     */
    List<Trajet> findAllByNumeroBus(int numeroBus);

    /**
     * @param busId
     * @return la liste des Trajets par BusId
     */
    List<Trajet> findAllByBusId(int busId);

    /**
     * @param busId
     * @return la liste des Trajets par BusId
     */
    List<Trajet> findAllById(List<Long> trajetsId);

}
