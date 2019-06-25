package com.pskwiercz.unittest.mockitospringboot.service;

import com.pskwiercz.unittest.mockitospringboot.data.Item;
import com.pskwiercz.unittest.mockitospringboot.data.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {

    @InjectMocks
    private ItemBusinessService itemBusinessService;

    @Mock
    private ItemRepository itemRepository;

    @Test
    public void testFindAll() {
        when(itemRepository.findAll()).thenReturn(Arrays.asList(
                new Item(2, "Item2", 10, 10),
                new Item(3, "Item3", 20, 20)));

        List<Item> items = itemBusinessService.retrieveAllItems();

        assertEquals(items.get(0).getValue(), 100);
        assertEquals(items.get(1).getValue(), 400);
    }

}