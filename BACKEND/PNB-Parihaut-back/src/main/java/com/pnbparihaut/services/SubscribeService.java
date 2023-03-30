package com.pnbparihaut.services;

import com.pnbparihaut.models.Customer;
import com.pnbparihaut.repositories.CustomerRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class SubscribeService {

    private final CustomerRepository customerRepos;

    @Autowired
    public SubscribeService(CustomerRepository customerRepos){
        this.customerRepos = customerRepos;
    }

    public Customer subscribeCustomer(Customer customer) {
        boolean error = false;
        if (customer.getId() != null){
            System.out.println("Id must be null to be auto-generated");
            error = true;
        }
        if (customer.getLastName() == null
                || customer.getFirstName() == null
                || customer.getEmail() == null
                || customer.getPhoneNumber() == null) {
            System.out.println("Fields must not be null (except id)");
            error = true;
        } else {
            if (!customer.getLastName().matches("^[a-zA-Z -]*$")) {
                System.out.println("Last name must contain only letters or '-' or space");
                error = true;
            }
            if (!customer.getFirstName().matches("^[a-zA-Z -]*$")) {
                System.out.println("First name must contain only letters or '-' or spaces");
                error = true;
            }
            if (customer.getEmail().indexOf("@") == -1 || customer.getEmail().indexOf(".") == -1 || customer.getEmail().indexOf(" ") != -1) {
                System.out.println("Email must contain '@' and '.' and must not contain space");
                error = true;
            }
            if (!customer.getPhoneNumber().matches("^[0-9 -]*$")) {
                System.out.println("Phone number must contain only numbers or '-' or spaces");
                error = true;
            }
        }


        if (error){
            return null;
        } else {
            return customerRepos.save(customer);
        }
    }

}
