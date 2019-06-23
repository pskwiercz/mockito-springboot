package com.pskwiercz.unittest.mockitospringboot.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class) // Which controller will be tested
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void itemControllerBasicTest() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc.perform(request).andReturn();

        assertEquals("{\"id\":1,\"name\":\"ball\",\"price\":10,\"quantity\":100}", response.getResponse().getContentAsString());
    }

    @Test
    public void itemControllerTest() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                // use json() instead string() - ignore nissing fields and spaces etc.
                // this also return true .andExpect(content().json("{\"id\": 1,\"name\":\"ball\"}"))
                .andExpect(content().json("{\"id\": 1,\"name\"    :    \"ball\",\"price\":10,\"quantity\":100}"))
                .andReturn();

    }
}