package com.pnbparihaut.models;

import com.pnbparihaut.PnbParihautBackApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = PnbParihautBackApplication.class)
@WebAppConfiguration
public class UserTest {

    private User user;

    @BeforeEach
    public void setup() {
        user = new User(null, null, null, null);
    }

    @Test
    public void testGetAndSetId() {
        Long id = 123L;
        user.setId(id);
        assertEquals(id, user.getId());
    }

    @Test
    public void testGetAndSetUsername() {
        String username = "0123456789";
        user.setUsername(username);
        assertEquals(username, user.getUsername());
    }

    @Test
    public void testGetAndSetPassword() {
        String password = "012345";
        user.setPassword(password);
        assertEquals(password, user.getPassword());
    }

    @Test
    public void testGetAndSetRole() {
        Role role = Role.USER;
        user.setRole(role);
        assertEquals(role, user.getRole());
    }
}
