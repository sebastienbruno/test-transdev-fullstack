package com.transdev.obt.exception;

public class TrajetNotFoundException extends Exception {

    public TrajetNotFoundException() {
        super("Le trajet demandée est introuvable");
    }

    public TrajetNotFoundException(String message) {
        super(message);
    }
}
