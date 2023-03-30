package com.pnbparihaut.customer.controllers;

import com.pnbparihaut.PnbParihautBackApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = PnbParihautBackApplication.class)
@WebAppConfiguration
public class SubscribeControllerTest {
    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    @WithMockUser()
    public void whenUserAccessSubscribeEndpoint_thenOk() throws Exception {
        mvc.perform(get("/subscribe"))
                .andExpect(status().isOk()); // le user peut y accéder
    }

    @Test
    @WithMockUser()
    public void whenUserCreateAccount_thenOk() throws Exception {
        mvc.perform(post("/subscribe").content("{\"lastName\": \"Le Goffic - Causse11\",\n" +
                        "\t\"firstName\": \"Liam\",\n" +
                        "\t\"email\": \"moi@mail.fr\",\n" +
                        "\t\"phoneNumber\": \"118 218\"}"))
                .andExpect(status().isOk()); // le user peut y accéder
    }
}
