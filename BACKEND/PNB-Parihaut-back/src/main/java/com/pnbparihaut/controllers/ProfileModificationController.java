package com.pnbparihaut.controllers;

import com.pnbparihaut.models.Customer;
import com.pnbparihaut.repositories.CustomerRepository;
import com.pnbparihaut.services.ProfileModificationService;
import com.pnbparihaut.services.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("profileMofidication")
public class ProfileModificationController {
    @Autowired
    private ProfileModificationService profileModificationService;
    @Autowired
    private CustomerRepository customerRepos;

    @PatchMapping
    public Customer modifyProfile(@RequestBody Customer customer) {
        return profileModificationService.modifyProfile(customer);
    }
}
