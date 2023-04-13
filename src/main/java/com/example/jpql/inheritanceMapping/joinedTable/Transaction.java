package com.example.jpql.inheritanceMapping.joinedTable;

import jakarta.persistence.*;

@Entity
@Table(name = "transaction")
@Inheritance(strategy = InheritanceType.JOINED)
public class Transaction {
    @Id
    private int id;
    private int amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
