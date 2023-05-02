package com.pnbparihaut.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Customer {

    @Id @GeneratedValue
    private Long id; // correspond au login de la personne qui se connecte
    private String lastName;
    private String firstName;
    private String email;
    private String phoneNumber;
    @OneToOne
    private User userLinked;

    public boolean checkAllAttributes() {
        return this.checkLastName() && this.checkFirstName() && this.checkEmail() && this.checkPhoneNumber();
    }

    public boolean checkLastName() {
        if (this.lastName != null) {
            // Last name must contain only letters or '-' or space
            return this.lastName.matches("^[a-zA-Z -]*$");
        } else {
            return false;
        }
    }

    public boolean checkFirstName() {
        if (this.firstName != null) {
            // First name must contain only letters or '-' or spaces
            return this.firstName.matches("^[a-zA-Z -]*$");
        } else {
            return false;
        }
    }

    public boolean checkEmail() {
        if (this.email != null) {
            // Email must contain '@' and '.' and must not contain space
            return this.email.contains("@") && this.email.contains(".") && !this.email.contains(" ");
        } else {
            return false;
        }
    }

    public boolean checkPhoneNumber() {
        if (this.phoneNumber != null) {
            // Phone number must contain only numbers or '-' or spaces
            return this.phoneNumber.matches("^[0-9 -]*$");
        } else {
            return false;
        }
    }
}
