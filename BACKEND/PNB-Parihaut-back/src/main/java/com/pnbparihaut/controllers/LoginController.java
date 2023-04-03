package com.pnbparihaut.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    /*@GetMapping("/login")
    public String loginEndpoint() {
        return "Login!";
    }*/

    @GetMapping("/admin")
    public String adminEndpoint() {
        return "Admin!";
    }

    @GetMapping("/user")
    public String userEndpoint() {
        return "User!";
    }

    @GetMapping("/home")
    public String allRolesEndpoint() {
        return "Accueil!";
    }

    @DeleteMapping("/delete")
    public String deleteEndpoint(@RequestBody String s) {
        return "I am deleting " + s;
    }
}