package com.pnbparihaut.services;

import com.pnbparihaut.PnbParihautBackApplication;
import com.pnbparihaut.models.Customer;
import com.pnbparihaut.models.User;
import com.pnbparihaut.repositories.CustomerRepository;
import com.pnbparihaut.services.ProfileModificationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest(classes = PnbParihautBackApplication.class)
@WebAppConfiguration
public class ProfileModificationServiceTest {
    private ProfileModificationService profileModificationService;
    @Mock
    public CustomerRepository customerRepository;
    private Customer customer;
    private User user;

    @BeforeEach
    public void initializeService() {
        user = new User();
        Mockito.when( customerRepository.save(any()) ).thenReturn(new Customer());
        Mockito.when( customerRepository.findById(1L) ).thenReturn(Optional.of(new Customer(1L, "Le Goffic", "Liam", "moi@mail.fr", "118 218", user)));
        Mockito.when( customerRepository.findById(2L) ).thenReturn(Optional.empty());
        profileModificationService = new ProfileModificationService(customerRepository);
        customer = new Customer();
    }

    @Test
    public void whenProfileModificationNotContainsId_thenUnsaved() {
        assertNull(profileModificationService.modifyProfile(customer));
    }
    @Test
    public void whenProfileModificationContainsUnassignedId_thenUnsaved() {
        customer.setId(2L);
        assertNull(profileModificationService.modifyProfile(customer));
    }
    @Test
    public void whenProfileModificationContainsAssignedId_thenSaved() {
        customer.setId(1L);
        assertNotNull(profileModificationService.modifyProfile(customer));
    }

    @Test
    public void whenUpdateLastNameCustomer_thenUpdateLastName() {
        Customer modificationsToDo = new Customer(1L, "Causse", null, null, null, user);
        Customer customerToModify = new Customer(1L, "Le Goffic", "Liam", "moi@mail.fr", "118 218", user);
        assertEquals(new Customer(1L, "Causse", "Liam", "moi@mail.fr", "118 218", user),
                profileModificationService.updateCustomer(modificationsToDo, customerToModify));
    }

    @Test
    public void whenUpdateEmailCustomer_thenUpdateEmail() {
        Customer modificationsToDo = new Customer(1L, null, null, "pasmoi@mail.fr", null, user);
        Customer customerToModify = new Customer(1L, "Le Goffic", "Liam", "moi@mail.fr", "118 218", user);
        assertEquals(new Customer(1L, "Le Goffic", "Liam", "pasmoi@mail.fr", "118 218", user),
                profileModificationService.updateCustomer(modificationsToDo, customerToModify));
    }

    @Test
    public void whenUpdatePhoneNumberCustomer_thenUpdatePhoneNumber() {
        Customer modificationsToDo = new Customer(1L, null, null, null, "0-0-0", user);
        Customer customerToModify = new Customer(1L, "Le Goffic", "Liam", "moi@mail.fr", "118 218", user);
        assertEquals(new Customer(1L, "Le Goffic", "Liam", "moi@mail.fr", "0-0-0", user),
                profileModificationService.updateCustomer(modificationsToDo, customerToModify));
    }

    @Test
    public void whenUpdateAllAttributesOfCustomer_thenUpdateAllAttributes() {
        Customer modificationsToDo = new Customer(1L, "Causse", "Alexandre", "pasmoi@mail.fr", "0-0-0", user);
        Customer customerToModify = new Customer(1L, "Le Goffic", "Liam", "moi@mail.fr", "118 218", user);
        assertEquals(new Customer(1L, "Causse", "Alexandre", "pasmoi@mail.fr", "0-0-0", user),
                profileModificationService.updateCustomer(modificationsToDo, customerToModify));
    }
}
