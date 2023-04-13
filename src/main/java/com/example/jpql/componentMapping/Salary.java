package com.example.jpql.componentMapping;

import jakarta.persistence.Embeddable;

@Embeddable
public class Salary {
    private int basicsalary;
    private int bonussalary;
    private int taxamount;
    private int specialallowancesalary;


    public int getBasicsalary() {
        return basicsalary;
    }

    public void setBasicsalary(int basicsalary) {
        this.basicsalary = basicsalary;
    }

    public int getBonussalary() {
        return bonussalary;
    }

    public void setBonussalary(int bonussalary) {
        this.bonussalary = bonussalary;
    }

    public int getTaxAmount() {
        return taxamount;
    }

    public void setTaxAmount(int taxAmount) {
        this.taxamount = taxAmount;
    }

    public int getSpecialAllowanceSalary() {
        return specialallowancesalary;
    }

    public void setSpecialAllowanceSalary(int specialAllowanceSalary) {
        this.specialallowancesalary = specialAllowanceSalary;
    }
}
