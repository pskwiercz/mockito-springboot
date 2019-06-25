package com.pskwiercz.unittest.mockitospringboot.service;

import com.pskwiercz.unittest.mockitospringboot.data.Item;
import com.pskwiercz.unittest.mockitospringboot.data.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemBusinessService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> retrieveAllItems() {
        List<Item> items = itemRepository.findAll();
        for(Item item : items) {
            item.setValue(item.getPrice() * item.getQuantity());
        }
        return items;
    }

    public Item retrieveHardcodedItem() {
        return new Item(2, "ball", 10, 100);
    }
}
