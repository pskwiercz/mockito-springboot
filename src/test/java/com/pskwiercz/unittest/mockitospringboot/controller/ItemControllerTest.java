package com.pskwiercz.unittest.mockitospringboot.controller;

import com.pskwiercz.unittest.mockitospringboot.data.Item;
import com.pskwiercz.unittest.mockitospringboot.service.ItemBusinessService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class) // Which controller will be tested
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService businessServiceMock;

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
                // use json() instead string() - ignore missing fields and spaces etc.
                // this also return true .andExpect(content().json("{\"id\": 1,\"name\":\"ball\"}"))
                .andExpect(content().json("{\"id\": 1,\"name\"    :    \"ball\",\"price\":10,\"quantity\":100}"))
                .andReturn();

    }

    @Test
    public void businessItemControllerTest() throws Exception {

        when(businessServiceMock.retrieveHardcodedItem()).thenReturn(new Item(2, "Item2", 10, 10));
        RequestBuilder request = MockMvcRequestBuilders
                .get("/item-from business-service")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                // use json() instead string() - ignore missing fields and spaces etc.
                // this also return true .andExpect(content().json("{\"id\": 1,\"name\":\"ball\"}"))
                .andExpect(content().json("{id:2, name:Item2, price:10, quantity:10}"))
                .andReturn();

    }

    @Test
    public void retrieveAllItemControllerTest() throws Exception {

        when(businessServiceMock.retrieveAllItems())
                .thenReturn(Arrays.asList(
                        new Item(2, "Item2", 10, 10),
                        new Item(3, "Item3", 20, 20)));

        RequestBuilder request = MockMvcRequestBuilders
                .get("/all-items")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[" +
                        "{id:2, name:Item2, price:10, quantity:10}," +
                        "{id:3, name:Item3, price:20, quantity:20}" +
                        "]"))
                .andReturn();

    }
}