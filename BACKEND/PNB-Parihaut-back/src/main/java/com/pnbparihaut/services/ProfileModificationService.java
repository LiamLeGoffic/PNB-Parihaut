package com.pnbparihaut.services;

import com.pnbparihaut.models.Customer;
import com.pnbparihaut.repositories.CustomerRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class ProfileModificationService {

    private final CustomerRepository customerRepos;

    @Autowired
    public ProfileModificationService(CustomerRepository customerRepos){
        this.customerRepos = customerRepos;
    }


    public Customer modifyProfile(Customer modificationsToDo){
        if (modificationsToDo.getId() == null) {
            return null;
        }
        Optional<Customer> optionalCustomerToModify = customerRepos.findById(modificationsToDo.getId());
        if (optionalCustomerToModify.isEmpty()) {
            return null;
        }
        Customer modifiedCustomer = updateCustomer(modificationsToDo, optionalCustomerToModify.get());
        if (modifiedCustomer.checkAttributes()) {
            return customerRepos.save(modifiedCustomer);
        } else {
            return null;
        }
    }

    public Customer updateCustomer(Customer modificationsToDo, Customer customerToModify) {
        if (modificationsToDo.getLastName() != null) {
            customerToModify.setLastName(modificationsToDo.getLastName());
        }
        if (modificationsToDo.getFirstName() != null) {
            customerToModify.setFirstName(modificationsToDo.getFirstName());
        }
        if (modificationsToDo.getEmail() != null) {
            customerToModify.setEmail(modificationsToDo.getEmail());
        }
        if (modificationsToDo.getPhoneNumber() != null) {
            customerToModify.setPhoneNumber(modificationsToDo.getPhoneNumber());
        }
        return customerToModify;
    }

}
