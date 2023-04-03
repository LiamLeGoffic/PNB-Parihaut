package com.pnbparihaut.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JwtResponse {
    private String jwtToken;

    public String getJwtToken() {

        return jwtToken;
    }

    public JwtResponse setJwtToken(String jwtToken) {

        this.jwtToken = jwtToken;
        return this;
    }
}
