package com.pnbparihaut.repositories;

import com.pnbparihaut.models.BankAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {

    List<BankAccount> findByOwnerId(Long id);
}
