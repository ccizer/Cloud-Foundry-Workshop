package com.cancizer.workshop.customers;

import com.cancizer.workshop.customers.repository.CustomerRepository;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.nio.file.Files;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SqlGroup({
        @Sql(value = "classpath:empty/reset.sql", executionPhase = BEFORE_TEST_METHOD),
        @Sql(value = "classpath:init/customer-data.sql", executionPhase = BEFORE_TEST_METHOD)
})
class CustomersApplicationTests {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldCreateOneCustomer() throws Exception {
        File file = ResourceUtils.getFile("classpath:init/customer.json");
        String customerToCreate = new String(Files.readAllBytes(file.toPath()));

        this.mockMvc.perform(post("/")
                        .contentType(APPLICATION_JSON)
                        .content(customerToCreate))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$", aMapWithSize(2)));

        assertThat(this.customerRepository.findAll().size(), equalTo(5));
    }

    @Test
    void shouldRetrieveAllCustomers() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$.[0].id").value(2))
                .andExpect(jsonPath("$.[1].id").value(3))
                .andExpect(jsonPath("$.[2].id").value(4))
                .andExpect(jsonPath("$.[3].id").value(5));
    }
}
