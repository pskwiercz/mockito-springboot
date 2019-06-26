package com.pskwiercz.unittest.mockitospringboot.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void findAllTest() {
        List<Item> itemList = itemRepository.findAll();
        assertEquals(3, itemList.size());
    }

    @Test
    public void findByIdTest() {
        Optional<Item> item = itemRepository.findById(1001);
        assertEquals("Item1", item.get().getName());
    }
}