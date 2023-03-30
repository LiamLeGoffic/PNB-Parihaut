package com.pnbparihaut.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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

    public boolean checkAttributes() {
        if (this.lastName == null || this.firstName == null || this.email == null || this.phoneNumber == null) {
            System.out.println("Fields must not be null (except id)");
            return false;
        }
        boolean error = true;
        if (!this.lastName.matches("^[a-zA-Z -]*$")) {
            System.out.println("Last name must contain only letters or '-' or space");
            error = false;
        }
        if (!this.firstName.matches("^[a-zA-Z -]*$")) {
            System.out.println("First name must contain only letters or '-' or spaces");
            error = false;
        }
        if (this.email.indexOf("@") == -1 || this.email.indexOf(".") == -1 || this.email.indexOf(" ") != -1) {
            System.out.println("Email must contain '@' and '.' and must not contain space");
            error = false;
        }
        if (!this.phoneNumber.matches("^[0-9 -]*$")) {
            System.out.println("Phone number must contain only numbers or '-' or spaces");
            error = false;
        }

        return error;
    }
}
