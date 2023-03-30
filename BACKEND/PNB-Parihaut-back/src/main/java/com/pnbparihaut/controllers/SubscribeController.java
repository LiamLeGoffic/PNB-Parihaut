package com.pnbparihaut.controllers;

import com.pnbparihaut.models.Customer;
import com.pnbparihaut.repositories.CustomerRepository;
import com.pnbparihaut.services.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("subscribe")
public class SubscribeController {
    private final SubscribeService subscribeService;
    @Autowired
    private CustomerRepository customerRepos;
    public SubscribeController(SubscribeService subscribeService) {
        this.subscribeService = subscribeService;
    }
    @GetMapping
    public Iterable<Customer> getAllCustomers(){ return customerRepos.findAll(); }
    @PostMapping
    public Customer subscribeCustomer(@RequestBody Customer customer){
        return subscribeService.subscribeCustomer(customer);
    }
    @PatchMapping
    public Customer modifyProfile(@RequestBody Customer customer) { return customerRepos.save(customer);}
}
