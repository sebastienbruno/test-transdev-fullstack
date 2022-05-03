package com.transdev.obt.exception;

public class NombrePlaceInsuffisantException extends RuntimeException {

    public NombrePlaceInsuffisantException(String message) {
        super(message);
    }

    public NombrePlaceInsuffisantException(String trajetDescription, int nbPlaceRestant, int nbPlaceSouhaite) {
        super("Le nombre de place restante ("+ nbPlaceRestant +") pour le trajet " + trajetDescription + " est insuffisant par rapport au nombre de place souhaité ("+ nbPlaceSouhaite +")");
    }
}
