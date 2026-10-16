package com.example.myprojectProduct.service;

import com.example.myprojectProduct.vo.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class ProductService {
    private final List<Product> products = new CopyOnWriteArrayList<>();

    Product p=new Product();
    {
        p.setProductID(1);
        p.setProductName("Mobile");
        products.add(p);
    }

    public List<Product> getProductInfo() {

        //List<Product>  sortedProds=products.stream().sorted(Comparator.comparingInt(Product::getProductID)).toList();
        return List.copyOf(products);
    }

    public Product addProductInfo(Product product) {
        products.add(product);
        return product;
    }

    public Optional<Product> updateProductName(int productId, String productName) {
        return products.stream()
                .filter(product -> product.getProductID() == productId)
                .findFirst()
                .map(product -> {
                    product.setProductName(productName);
                    return product;
                });
    }

    public boolean deleteProduct(int productId) {
        return products.removeIf(product -> product.getProductID() == productId);
    }
}
