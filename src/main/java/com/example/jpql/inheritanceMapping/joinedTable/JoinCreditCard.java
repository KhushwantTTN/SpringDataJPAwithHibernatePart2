package com.example.jpql.inheritanceMapping.joinedTable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "creditcard")
@PrimaryKeyJoinColumn(name = "id")
public class JoinCreditCard extends Transaction {

    @Column(name = "checknumber")
    private String cardNumber;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
