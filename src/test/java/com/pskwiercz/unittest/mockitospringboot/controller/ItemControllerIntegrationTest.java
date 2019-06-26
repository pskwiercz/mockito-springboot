package com.pskwiercz.unittest.mockitospringboot.controller;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemControllerIntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void contextLoad() throws JSONException {
        String response = testRestTemplate.getForObject("/all-items", String.class);
        JSONAssert.assertEquals("[{id:1001},{id:1002},{id:1003}]", response, false);
    }

}
