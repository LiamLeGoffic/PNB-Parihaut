package com.pnbparihaut.services;

import com.pnbparihaut.PnbParihautBackApplication;
import com.pnbparihaut.models.Customer;
import com.pnbparihaut.repositories.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
/*
@SpringBootTest(classes = PnbParihautBackApplication.class)
@WebAppConfiguration
public class SubscribeServiceTest {
    private SubscribeService subscribeService;
    @Mock
    public CustomerRepository customerRepository;

    @BeforeEach
    public void initializeService() {
        Mockito.when( customerRepository.save(any()) ).thenReturn(new Customer());
        subscribeService = new SubscribeService(customerRepository);
    }

    @Test
    public void whenNewCustomerContainsIdNotNull_thenUnsaved(){
        Customer customer = new Customer(123123L, "Le Goffic", "Liam", "moi@mail.fr", "118 218");
        assertNull(subscribeService.subscribeCustomer(customer));
    }

    @Test
    public void whenNewCustomerNotContainsName_thenUnsaved(){
        Customer customer = new Customer(null, null, "Liam", "moi@mail.fr", "118 218");
        assertNull(subscribeService.subscribeCustomer(customer));
    }

    @Test
    public void whenNewCustomerContainsBadName_thenUnsaved(){
        Customer customer = new Customer(null, "jilj123", "Liam", "moi@mail.fr", "118 218");
        assertNull(subscribeService.subscribeCustomer(customer));
    }

    @Test
    public void whenNewCustomerContainsBadEmail_thenUnsaved(){
        Customer customer = new Customer(null, "Le Goffic - Causse", "Liam", "moima il.fr", "118 218");
        assertNull(subscribeService.subscribeCustomer(customer));
    }

    @Test
    public void whenNewCustomerContainsBadPhoneNumber_thenUnsaved(){
        Customer customer = new Customer(null, "Le Goffic - Causse", "Liam", "moi@mail.fr", "118 218");
        assertNull(subscribeService.subscribeCustomer(customer));
    }

    @Test
    public void whenNewCustomerContainsAllRequirement_thenSaved(){
        Customer customer = new Customer(null, "Le Goffic - Causse", "Liam", "moi@mail.fr", "118 218");
        assertNotNull(subscribeService.subscribeCustomer(customer));
    }
}*/
