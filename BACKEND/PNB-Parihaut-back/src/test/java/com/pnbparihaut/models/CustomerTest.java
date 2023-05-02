package com.pnbparihaut.models;

import com.pnbparihaut.PnbParihautBackApplication;
import com.pnbparihaut.models.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = PnbParihautBackApplication.class)
@WebAppConfiguration
public class CustomerTest {

    private Customer customer;

    @BeforeEach
    public void setup() {
        customer = new Customer(null, null, null, null, null, null);
    }

    @Test
    public void testGetAndSetId() {
        Long id = 123L;
        customer.setId(id);
        assertEquals(id, customer.getId());
    }

    @Test
    public void testGetAndSetLastName() {
        String lastName = "Le Goffic";
        customer.setLastName(lastName);
        assertEquals(lastName, customer.getLastName());
    }

    @Test
    public void testGetAndSetFirstName() {
        String firstName = "Liam";
        customer.setFirstName(firstName);
        assertEquals(firstName, customer.getFirstName());
    }

    @Test
    public void testGetAndSetEmail() {
        String email = "moi@mail.fr";
        customer.setEmail(email);
        assertEquals(email, customer.getEmail());
    }

    @Test
    public void testGetAndSetPhoneNumber() {
        String phoneNumber = "118 218";
        customer.setPhoneNumber(phoneNumber);
        assertEquals(phoneNumber, customer.getPhoneNumber());
    }

    @Test
    public void testGetAndSetUserLinked() {
        User userLinked = new User();
        customer.setUserLinked(userLinked);
        assertEquals(userLinked, customer.getUserLinked());
    }

    // Test on checkLastName()
    @Test
    public void whenNoLastName_thenCheckLastNameReturnFalse() {
        customer.setLastName(null);
        assertFalse(customer.checkLastName());
    }

    @Test
    public void whenBadLastName_thenCheckLastNameReturnFalse() {
        customer.setLastName("464qxs6");
        assertFalse(customer.checkLastName());
    }

    @Test
    public void whenValidLastName_thenCheckLastNameReturnTrue() {
        customer.setLastName("Le Goffic - Causse");
        assertTrue(customer.checkLastName());
    }

    // Test on checkFirstName()
    @Test
    public void whenNoFirstName_thenCheckFirstNameReturnFalse() {
        assertFalse(customer.checkFirstName());
    }

    @Test
    public void whenBadFirstName_thenCheckFirstNameReturnFalse() {
        customer.setFirstName("nvzjv46scd864");
        assertFalse(customer.checkFirstName());
    }

    @Test
    public void whenValidFirstName_thenCheckFirstNameReturnTrue() {
        customer.setFirstName("Liam Alexandre-Georges");
        assertTrue(customer.checkFirstName());
    }

    // Test on checkEmail()
    @Test
    public void whenNoEmail_thenCheckEmailReturnFalse() {
        assertFalse(customer.checkEmail());
    }

    @Test
    public void whenBadEmail_thenCheckEmailReturnFalse() {
        customer.setEmail("soi64");
        assertFalse(customer.checkEmail());
    }

    @Test
    public void whenValidEmail_thenCheckEmailReturnTrue() {
        customer.setEmail("moi@mail.fr");
        assertTrue(customer.checkEmail());
    }

    // Test on checkPhoneNumber()
    @Test
    public void whenNoPhoneNumber_thenCheckPhoneNumberReturnFalse() {
        assertFalse(customer.checkPhoneNumber());
    }

    @Test
    public void whenBadPhoneNumber_thenCheckPhoneNumberReturnFalse() {
        customer.setPhoneNumber("118_218");
        assertFalse(customer.checkPhoneNumber());
    }

    @Test
    public void whenValidPhoneNumber_thenCheckPhoneNumberReturnTrue() {
        customer.setPhoneNumber("118 218");
        assertTrue(customer.checkPhoneNumber());
    }

}
