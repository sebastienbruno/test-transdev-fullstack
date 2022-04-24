package com.transdev.obt.dto;

import com.transdev.obt.domain.Facture;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FactureDto {
    private Long factureId;
    private Long numero;

    public static FactureDto fromEntity(Facture facture) {
        return new FactureDto(facture.getFactureId(), facture.getNumero());
    }
}
