package com.pskwiercz.unittest.mockitospringboot.controller;

import com.pskwiercz.unittest.mockitospringboot.model.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @GetMapping("/dummy-item")
    public Item dummyItem() {
        return new Item(1, "ball", 10, 100);
    }
}
