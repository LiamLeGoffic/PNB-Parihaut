package com.pnbparihaut;

import com.pnbparihaut.models.Customer;
import com.pnbparihaut.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PnbParihautBackApplication implements CommandLineRunner {

    @Autowired
    CustomerRepository customerRepos;

    public static void main(String[] args) {

        SpringApplication.run(PnbParihautBackApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("letzzzz gooooo");

        customerRepos.save(new Customer(null, "Le Goffic", "Liam", "moi@mail.fr", "118 218"));
    }
}
