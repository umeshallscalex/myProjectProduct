package com.example.myprojectProduct;

import com.example.myprojectProduct.vo.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MyProjectDemoApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext container=SpringApplication.run(MyProjectDemoApplication.class, args);
        Product prod=container.getBean(Product.class);
        System.out.println(prod);
    }

}
