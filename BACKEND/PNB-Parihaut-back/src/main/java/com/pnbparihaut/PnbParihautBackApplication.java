package com.pnbparihaut;

import com.pnbparihaut.auth.AuthenticationService;
import com.pnbparihaut.auth.RegisterRequest;
import com.pnbparihaut.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;

@SpringBootApplication
public class PnbParihautBackApplication implements CommandLineRunner {

    @Autowired
    AuthenticationService authenticationService;
    @Autowired
    UserRepository userRepos;

    public static void main(String[] args) {
        SpringApplication.run(PnbParihautBackApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("letzzzz gooooo");
        RegisterRequest r1 = new RegisterRequest("Le Goffic", "Liam", "moi@mail.fr", "118 218", "5555555555", "012345");
        ResponseEntity.ok(authenticationService.register(r1));
    }
}
