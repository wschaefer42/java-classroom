package org.example.demospring;

import jakarta.inject.Inject;
import org.example.demospring.resource.HealthResource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(HealthResource.class)
@AutoConfigureWebMvc
public class HealthResourceTests {
    @Inject
    private MockMvc mockMvc;

    @Test
    public void pingGetPONG() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/health/ping")
                        .accept(MediaType.TEXT_PLAIN))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("PONG"));

    }
}
