package com.pnbparihaut.services;

import com.pnbparihaut.models.BankAccount;
import com.pnbparihaut.repositories.BankAccountRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class BankAccountService {

    private final BankAccountRepository bankAccountRepos;

    @Autowired
    public BankAccountService(BankAccountRepository bankAccountRepos) {
        this.bankAccountRepos = bankAccountRepos;
    }

    public List<BankAccount> getAccountListByCustomerId(Long id) {
        return bankAccountRepos.findByOwnerId(id);
    }

    public BankAccount saveAccount(BankAccount bankAccount) {
        return bankAccountRepos.save(bankAccount);
    }

    public void transfer(Long idCreditor, Long idDebtor, double amount) {
        Optional<BankAccount> optionalCreditor = bankAccountRepos.findById(idCreditor);
        Optional<BankAccount> optionalDebtor = bankAccountRepos.findById(idDebtor);
        if (optionalCreditor.isPresent() && optionalDebtor.isPresent()) {
            BankAccount creditor = optionalCreditor.get();
            BankAccount debtor = optionalDebtor.get();
            if (debtor.checkAvailableDebit(amount)) {
                creditor.credit(amount);
                debtor.debit(amount);
                bankAccountRepos.save(creditor);
                bankAccountRepos.save(debtor);
            }
        }
    }
}
