package com.transdev.obt.exception;

public class TrajetNotFoundException extends RuntimeException {

    public TrajetNotFoundException() {
        super("Le trajet demandée est introuvable");
    }

    public TrajetNotFoundException(String message) {
        super(message);
    }
}
