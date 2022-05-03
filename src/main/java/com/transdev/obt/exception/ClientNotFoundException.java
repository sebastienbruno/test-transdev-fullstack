package com.transdev.obt.exception;

public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException(Long clientId) {
        super("Le client avec l'id " + clientId + " est introuvable");
    }

    public ClientNotFoundException(String message) {
        super(message);
    }
}
