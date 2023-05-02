package com.pnbparihaut.controllers;

import com.pnbparihaut.models.BankAccount;
import com.pnbparihaut.services.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bankAccount")
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @PostMapping("/newAccount")
    public BankAccount saveBankAccount(@RequestBody BankAccount bankAccount) {
        return bankAccountService.saveAccount(bankAccount);
    }

    @GetMapping("/owner/{id}")
    public List<BankAccount> getAccountListByCustomerId(@PathVariable Long id) {
        return bankAccountService.getAccountListByCustomerId(id);
    }

    @PatchMapping("/debit")
    public BankAccount saveAccount(@RequestBody BankAccount bankAccount) {
        return bankAccountService.saveAccount(bankAccount);
    }

    @PatchMapping("/payment/{idCreditor}/{idDebtor}/{amount}")
    public void payment(@PathVariable Long idCreditor, @PathVariable Long idDebtor, @PathVariable double amount) {
        bankAccountService.transfer(idCreditor, idDebtor, amount);
    }
}
