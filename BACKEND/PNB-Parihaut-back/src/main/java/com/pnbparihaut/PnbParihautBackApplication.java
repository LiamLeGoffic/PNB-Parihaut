package com.pnbparihaut;

import com.pnbparihaut.models.Customer;
import com.pnbparihaut.models.User;
import com.pnbparihaut.repositories.CustomerRepository;
import com.pnbparihaut.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class PnbParihautBackApplication implements CommandLineRunner {

    @Autowired
    CustomerRepository customerRepos;
    @Autowired
    UserRepository userRepos;

    public static void main(String[] args) {
        SpringApplication.run(PnbParihautBackApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("letzzzz gooooo");
        userRepos.save(new User("user1", new BCryptPasswordEncoder().encode("password123"), "USER", true));
        customerRepos.save(new Customer(null, "Le Goffic", "Liam", "moi@mail.fr", "118 218"));
    }
}
