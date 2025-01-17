package com.teles.basicProject.resources;

import com.teles.basicProject.entities.Product;
import com.teles.basicProject.services.ProductService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
@Resource
public class ProductResource {

    @Autowired
    private ProductService productService;

    @GetMapping()
    public ResponseEntity<List<Product>> findAll(){
        List<Product> list = productService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable long id){
        Product product = productService.findById(id);
        return ResponseEntity.ok().body(product);
    }
}
