package com.pnbparihaut.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class BankAccount {
    @Id @GeneratedValue
    private Long id;
    private String IBAN;
    private String BIC;
    private double amount;
    private double overdraft;
    @ManyToOne
    private Customer owner;

    public void credit(double amount) {
        this.amount += amount;
    }
    public void debit(double amount) {
        this.amount -= amount;
    }
    public boolean checkAvailableDebit(double amount){
        if (amount < 0) {
            return false;
        } else if (this.amount + this.overdraft < amount) {
            return false;
        } else {
            return true;
        }
    }

}
