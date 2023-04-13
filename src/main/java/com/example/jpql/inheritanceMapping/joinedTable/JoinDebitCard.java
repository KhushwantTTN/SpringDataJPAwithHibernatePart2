package com.example.jpql.inheritanceMapping.joinedTable;

import jakarta.persistence.*;

@Entity
@Table(name = "debitcard")

@PrimaryKeyJoinColumn(name = "id")
public class JoinDebitCard extends Transaction{

    @Column(name = "cardnumber")
    private String checkNumber;

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }
}
