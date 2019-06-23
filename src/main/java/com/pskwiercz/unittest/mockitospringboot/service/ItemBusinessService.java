package com.pskwiercz.unittest.mockitospringboot.service;

import com.pskwiercz.unittest.mockitospringboot.model.Item;
import org.springframework.stereotype.Service;

@Service
public class ItemBusinessService {

    public Item retrieveHardcodedItem() {
        return new Item(2, "ball", 10, 100);
    }
}
