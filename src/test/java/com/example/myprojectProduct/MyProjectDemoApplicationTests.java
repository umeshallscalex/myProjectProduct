package com.example.myprojectProduct;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class MyProjectDemoApplicationTests {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void applicationLoadsSuccessfully() {
        assertNotNull(applicationContext.getBean(MyProjectDemoApplication.class));
    }

}
