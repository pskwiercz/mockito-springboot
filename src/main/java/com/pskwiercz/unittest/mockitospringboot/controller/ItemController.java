package com.pskwiercz.unittest.mockitospringboot.controller;

import com.pskwiercz.unittest.mockitospringboot.model.Item;
import com.pskwiercz.unittest.mockitospringboot.service.ItemBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    private ItemBusinessService itemBusinessService;

    @Autowired
    public ItemController(ItemBusinessService itemBusinessService) {
        this.itemBusinessService = itemBusinessService;
    }

    @GetMapping("/dummy-item")
    public Item dummyItem() {
        return new Item(1, "ball", 10, 100);
    }

    @GetMapping("/item-from business-service")
    public Item itemFromBusinessService() {
        return itemBusinessService.retrieveHardcodedItem();
    }
}
