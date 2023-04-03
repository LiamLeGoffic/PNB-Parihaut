package com.pnbparihaut.customer.services;

import com.pnbparihaut.PnbParihautBackApplication;
import com.pnbparihaut.models.Customer;
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

    @BeforeEach
    public void initializeService() {
        Mockito.when( customerRepository.save(any()) ).thenReturn(new Customer());
        Mockito.when( customerRepository.findById(1L) ).thenReturn(Optional.of(new Customer(1L, "Le Goffic", "Liam", "moi@mail.fr", "118 218")));
        Mockito.when( customerRepository.findById(2L) ).thenReturn(Optional.empty());
        profileModificationService = new ProfileModificationService(customerRepository);
    }

    @Test
    public void whenProfileModificationNotContainsId_thenUnsaved() {
        Customer customer = new Customer();
        assertNull(profileModificationService.modifyProfile(customer));
    }
    @Test
    public void whenProfileModificationContainsUnassignedId_thenUnsaved() {
        Customer customer = new Customer(2L, null, null, null, null);
        assertNull(profileModificationService.modifyProfile(customer));
    }
    @Test
    public void whenProfileModificationContainsBadSyntax_thenSaved() {
        //Mockito.when( any(Customer.class).checkAttributes() ).thenReturn(true);
        Customer customer = new Customer(1L, "1561351", null, null, null);
        assertNull(profileModificationService.modifyProfile(customer));
    }

    @Test
    public void whenProfileModificationContainsAssignedId_thenSaved() {
        Customer customer = new Customer(1L, null, null, null, null);
        assertNotNull(profileModificationService.modifyProfile(customer));
    }

    @Test
    public void whenUpdateLastNameCustomer_thenUpdateLastName() {
        Customer modificationsToDo = new Customer(1L, "Causse", null, null, null);
        Customer customerToModify = new Customer(1L, "Le Goffic", "Liam", "moi@mail.fr", "118 218");
        assertEquals(new Customer(1L, "Causse", "Liam", "moi@mail.fr", "118 218"),
                profileModificationService.updateCustomer(modificationsToDo, customerToModify));
    }

    @Test
    public void whenUpdateEmailCustomer_thenUpdateEmail() {
        Customer modificationsToDo = new Customer(1L, null, null, "pasmoi@mail.fr", null);
        Customer customerToModify = new Customer(1L, "Le Goffic", "Liam", "moi@mail.fr", "118 218");
        assertEquals(new Customer(1L, "Le Goffic", "Liam", "pasmoi@mail.fr", "118 218"),
                profileModificationService.updateCustomer(modificationsToDo, customerToModify));
    }

    @Test
    public void whenUpdatePhoneNumberCustomer_thenUpdatePhoneNumber() {
        Customer modificationsToDo = new Customer(1L, null, null, null, "0-0-0");
        Customer customerToModify = new Customer(1L, "Le Goffic", "Liam", "moi@mail.fr", "118 218");
        assertEquals(new Customer(1L, "Le Goffic", "Liam", "moi@mail.fr", "0-0-0"),
                profileModificationService.updateCustomer(modificationsToDo, customerToModify));
    }

    @Test
    public void whenUpdateAllAttributesOfCustomer_thenUpdateAllAttributes() {
        Customer modificationsToDo = new Customer(1L, "Causse", "Alexandre", "pasmoi@mail.fr", "0-0-0");
        Customer customerToModify = new Customer(1L, "Le Goffic", "Liam", "moi@mail.fr", "118 218");
        assertEquals(new Customer(1L, "Causse", "Alexandre", "pasmoi@mail.fr", "0-0-0"),
                profileModificationService.updateCustomer(modificationsToDo, customerToModify));
    }
}
