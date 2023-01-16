package com.masai.controller;

import com.masai.exception.*;
import com.masai.model.*;
import com.masai.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) throws CustomException{

        Product added = productService.addProduct(product);

        return new ResponseEntity<>(added,HttpStatus.CREATED);

    }

    @DeleteMapping("/{productID}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer productID) throws CustomException{

        String deleted = productService.deleteProduct(productID);

        return new ResponseEntity<>(deleted,HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() throws CustomException{

        List<Product> products = productService.getAllProducts();

        return new ResponseEntity<>(products,HttpStatus.OK);

    }

    @GetMapping("/{productID}")
    public ResponseEntity<Product> findProductById(@PathVariable Integer productID) throws CustomException{

        Product product = productService.findProductById(productID);

        return new ResponseEntity<>(product,HttpStatus.OK);

    }

    @PutMapping("/reduceQuantity/{productID}/{quantity}")
    public ResponseEntity<Product> reduceQuantity(@PathVariable Integer productID, @PathVariable Integer quantity) throws CustomException{

        Product product = productService.reduceQuantity(productID,quantity);

        return new ResponseEntity<>(product,HttpStatus.OK);

    }

}
