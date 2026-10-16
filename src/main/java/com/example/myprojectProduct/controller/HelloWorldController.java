package com.example.myprojectProduct.controller;

import com.example.myprojectProduct.service.ProductService;
import com.example.myprojectProduct.vo.Product;
import com.example.myprojectProduct.vo.ProductNameUpdateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class HelloWorldController {

    private final ProductService service;

    public HelloWorldController(ProductService service) {
        this.service = service;
    }

    @GetMapping(value = "/hello")
    String HelloWorld()
    {
        return "Hello World";
    }

    @GetMapping(value = "/name")
    String HelloName()
    {
      return "Umesh";
    }

    @GetMapping(value = "/name/{name}")
    String HelloName(@PathVariable("name") String test)
    {
        return "Umesh"+test;
    }

    @GetMapping(value = "/productinfo")
    public List<Product> getProdInfo()
    {
       return  service.getProductInfo();
    }

    @PostMapping("/productadd")
    public ResponseEntity<Product> addProductInfo(@RequestBody Product product) {
        Product savedProduct = service.addProductInfo(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    @PutMapping("/{productId}/name")
    public ResponseEntity<Product> updateProductName(
            @PathVariable int productId,
            @RequestBody ProductNameUpdateRequest request) {
        if (request == null || request.productName() == null || request.productName().isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        return service.updateProductName(productId, request.productName())
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int productId) {
        if (service.deleteProduct(productId)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/getproductinfo")
    public ResponseEntity<List<Product>> getProdInfoResp() {
        List<Product> products = service.getProductInfo();
        if (products.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }

}
