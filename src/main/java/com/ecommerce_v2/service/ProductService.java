package com.ecommerce_v2.service;

import com.ecommerce_v2.Dtos.ProductDto;
import com.ecommerce_v2.model.Category;
import com.ecommerce_v2.model.Product;
import com.ecommerce_v2.repositories.CategoryRepo;
import com.ecommerce_v2.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;
    @Autowired
    CategoryRepo categoryRepo;

    public ResponseEntity<?> createproduct(ProductDto productDto, Category category) {
        Product product=new Product();
        product.setPdesc(productDto.getPdesc());
        product.setPimgurl(productDto.getPimgurl());
        product.setPname(productDto.getPname());
        product.setPrice(productDto.getPrice());
        product.setCategory(category);
        productRepo.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
