package com.transdev.obt.model;

import lombok.Data;

@Data
public class MoyenPaiement {

    private String cardNumber;
    private String expirationDate;
    private String email;

    public boolean isCardPaiement() {
        return !this.getCardNumber().isEmpty() && !this.getExpirationDate().isEmpty();
    }

    public boolean isPaypalPaiement() {
        return !this.getEmail().isEmpty();
    }
}
