package com.transdev.obt.dto;

import java.time.LocalDateTime;

import com.transdev.obt.domain.Trajet;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrajetDto {
    
    private Long trajetId;
    private int nbrPlace;
    private LocalDateTime dateDepart;
    private float prix;
    private BusDto bus;
    private boolean estRemise;
    private float prixRemise;

    public static TrajetDto fromEntity(Trajet trajet) {
        return TrajetDto.builder()
            .trajetId(trajet.getTrajetId())
            .nbrPlace(trajet.getNbrPlace())
            .dateDepart(trajet.getDateDepart())
            .prix(trajet.getPrix())
            .bus(BusDto.fromEntity(trajet.getBus()))
            .estRemise(trajet.getPrix()>100)
            .prixRemise(trajet.getPrix()>100 ? trajet.getPrix()*0.95f : trajet.getPrix()).build();
    }
}