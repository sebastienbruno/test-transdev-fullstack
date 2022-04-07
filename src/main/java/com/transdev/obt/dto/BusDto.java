package com.transdev.obt.dto;

import java.io.Serializable;

import com.transdev.obt.domain.Bus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BusDto implements Serializable {

    private Long busId;
    private int numeroBus;

    public static BusDto fromEntity(Bus bus) {
        return new BusDto(bus.getBusId(), bus.getNumeroBus());
    }

    public Bus toEntity() {
        return new Bus(this.busId, this.numeroBus);
    }

}
