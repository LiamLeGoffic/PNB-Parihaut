package com.pnbparihaut;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PnbParihautBackApplication implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(PnbParihautBackApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("letzzzz gooooo");
    }
}
