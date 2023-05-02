package com.pnbparihaut.services;

import com.pnbparihaut.PnbParihautBackApplication;
import com.pnbparihaut.models.BankAccount;
import com.pnbparihaut.repositories.BankAccountRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@SpringBootTest(classes = PnbParihautBackApplication.class)
@WebAppConfiguration
public class BankAccountServiceTest {
    private BankAccountService bankAccountService;
    @Mock
    public BankAccountRepository bankAccountRepository;
    private BankAccount creditor;
    private BankAccount debtor;
    private static Instant startedTests;
    @BeforeAll
    public static void initStartingTime(){
        startedTests = Instant.now();
    }
    @AfterAll
    public static void showTestDuration(){
        final Instant endedTests = Instant.now();
        final long duration = Duration.between(startedTests, endedTests).toMillis();
        System.out.println(MessageFormat.format("Testing time : {0} ms", duration));
    }
    @BeforeEach
    public void initializeService() {
        creditor = new BankAccount(null, null, null, 0, 500, null);
        debtor = new BankAccount(null, null, null, 500, 500, null);
        Mockito.when( bankAccountRepository.save(any()) ).thenReturn(null);
        Mockito.when( bankAccountRepository.findById(1L) ).thenReturn(Optional.of(creditor));
        Mockito.when( bankAccountRepository.findById(2L) ).thenReturn(Optional.of(debtor));
        Mockito.when( bankAccountRepository.findById(3L) ).thenReturn(Optional.empty());
        bankAccountService = new BankAccountService(bankAccountRepository);
    }

    @Test
    public void whenTransferFromBadDebtor_thenDisplayError(){
        bankAccountService.transfer(1L, 3L, 600);
        verify(bankAccountRepository).findById(1L);
        verify(bankAccountRepository).findById(3L);
        assertEquals(0, creditor.getAmount());
    }
    @Test
    public void whenTransferToBadCreditor_thenDisplayError(){
        bankAccountService.transfer(3L, 2L, 600);
        assertEquals(500, debtor.getAmount());
    }
    @Test
    public void whenGoodCreditorAndDebtor_thenDoTransfer(){
        bankAccountService.transfer(1L, 2L, 600);
        assertEquals(600, creditor.getAmount());
        assertEquals(-100, debtor.getAmount());
    }
}
