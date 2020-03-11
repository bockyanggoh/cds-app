package com.berkeley.cds.IntegrationTests;

import com.berkeley.cds.IntegrationTests.Configuration.RedisTestConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.util.Assert;

@ActiveProfiles("test")
@SpringBootTest(classes = RedisTestConfiguration.class)
@AutoConfigureMockMvc
public class ViewIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void PlaceholderTest() {
        Assert.isTrue(true);
    }

    @Test
    public void RootPageRenderSuccess() throws Exception {
        this.mockMvc.perform(get("/"))
                .andExpect(status().is(200));
    }
}
