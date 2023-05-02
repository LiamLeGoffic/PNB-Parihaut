package com.pnbparihaut.models;

import com.pnbparihaut.PnbParihautBackApplication;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = PnbParihautBackApplication.class)
@WebAppConfiguration
class BankAccountTest {

    private BankAccount bankAccount;

    @BeforeEach
    public void setup(){
        bankAccount = new BankAccount();
    }
    @AfterEach
    public void erase(){
        bankAccount = null;
    }

    @Test
    public void testGetAndSetId() {
        Long id = 123L;
        bankAccount.setId(id);
        assertEquals(id, bankAccount.getId());
    }

    @Test
    public void testGetAndSetIBAN() {
        String iban = "FR1234567890";
        bankAccount.setIBAN(iban);
        assertEquals(iban, bankAccount.getIBAN());
    }

    @Test
    public void testGetAndSetBIC() {
        String bic = "ABCDDEFFGHI";
        bankAccount.setBIC(bic);
        assertEquals(bic, bankAccount.getBIC());
    }

    @Test
    public void testGetAndSetAmount() {
        double amount = 1000;
        bankAccount.setAmount(amount);
        assertEquals(amount, bankAccount.getAmount());
    }

    @Test
    public void testGetAndSetOverdraft() {
        double overdraft = 500;
        bankAccount.setOverdraft(overdraft);
        assertEquals(overdraft, bankAccount.getOverdraft());
    }

    @Test
    public void testGetAndSetOwner() {
        Customer owner = new Customer();
        bankAccount.setOwner(owner);
        assertEquals(owner, bankAccount.getOwner());
    }

    @Test
    public void testAllArgsConstructor() {
        Customer owner = new Customer();
        bankAccount = new BankAccount(123L, "FR1234567890", "ABCDDEFFGHI", 1000, 500, owner);
        assertEquals(new BankAccount(123L, "FR1234567890", "ABCDDEFFGHI", 1000, 500, owner), bankAccount );
    }

    @Test
    public void testCredit() {
        double amount = 1000;
        bankAccount.credit(amount);
        assertEquals(1000, bankAccount.getAmount());
    }

    @Test
    public void testDebit() {
        bankAccount.debit(1000);
        assertEquals(-1000, bankAccount.getAmount());
    }

    @Test
    public void testCheckAvailableDebitWithNegativeAmount() {
        assertFalse(bankAccount.checkAvailableDebit(-1000));
    }

    @Test
    public void testCheckAvailableDebitWhitAmountExceedingFunds() {
        bankAccount.setAmount(1000);
        bankAccount.setOverdraft(500);
        assertFalse(bankAccount.checkAvailableDebit(2000));
    }

    @Test
    public void testCheckAvailableDebitWhitAvailableAmount() {
        bankAccount.setAmount(1000);
        bankAccount.setOverdraft(500);
        assertTrue(bankAccount.checkAvailableDebit(1200));
    }
}