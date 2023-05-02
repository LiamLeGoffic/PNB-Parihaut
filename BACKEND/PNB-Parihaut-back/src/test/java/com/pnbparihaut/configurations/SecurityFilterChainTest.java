package com.pnbparihaut.configurations;

import com.pnbparihaut.PnbParihautBackApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = PnbParihautBackApplication.class)
@WebAppConfiguration
public class SecurityFilterChainTest {
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
    @WithAnonymousUser
    public void whenAnonymousAccessLogin_thenOk() throws Exception {
        mvc.perform(get("/login"))
                .andExpect(status().isOk());
    }

    @Test
    @WithAnonymousUser
    public void whenAnonymousAccessRestrictedEndpoint_thenIsUnauthorized() throws Exception {
        mvc.perform(get("/all"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    //@WithUserDetails()
    @WithMockUser(username = "user", roles = {"USER"})
    public void whenUserAccessUserSecuredEndpoint_thenOk() throws Exception {
        mvc.perform(get("/user"))
                .andExpect(status().isOk()); // le user peut y accéder
    }

    @Test
    @WithMockUser()
    public void whenUserAccessRestrictedEndpoint_thenOk() throws Exception {
        mvc.perform(get("/all"))
                .andExpect(status().isOk()); // le user peut y accéder
    }

    @Test
    @WithMockUser()
    public void whenUserAccessAdminSecuredEndpoint_thenIsForbidden() throws Exception {
        mvc.perform(get("/admin"))
                .andExpect(status().isForbidden()); // le user ne peut pas y accéder
    }

    @Test
    @WithMockUser()
    public void whenUserAccessDeleteSecuredEndpoint_thenIsForbidden() throws Exception {
        mvc.perform(delete("/delete"))
                .andExpect(status().isForbidden()); // le user ne peut pas y accéder
    }

    @Test
    //@WithUserDetails(value = "admin")
    @WithMockUser(roles = {"ADMIN"})
    public void whenAdminAccessUserEndpoint_thenOk() throws Exception {
        mvc.perform(get("/user"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    public void whenAdminAccessAdminSecuredEndpoint_thenIsOk() throws Exception {
        mvc.perform(get("/admin"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    public void whenAdminAccessDeleteSecuredEndpoint_thenIsOk() throws Exception {
        mvc.perform(delete("/delete").content("{}"))
                .andExpect(status().isOk());
    }
}
