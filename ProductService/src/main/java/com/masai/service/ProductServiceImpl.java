package com.masai.service;

import com.masai.exception.*;
import com.masai.model.*;
import com.masai.repositery.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product addProduct(Product product) throws CustomException {

        return productRepo.save(product);

    }

    @Override
    public String deleteProduct(Integer productID) throws CustomException {

        Product product = productRepo.findById(productID).orElseThrow(()->new CustomException("No product found with id : "+productID));

        productRepo.delete(product);

        return "Product with id "+productID+" deleted successfully";

    }

    @Override
    public List<Product> getAllProducts() throws CustomException {

        List<Product> products = productRepo.findAll();

        if(products.isEmpty())
        {
            throw new CustomException("No products found");
        }
        else
        {
            return products;
        }

    }

    @Override
    public Product findProductById(Integer productID) throws CustomException {

        Product product = productRepo.findById(productID).orElseThrow(()->new CustomException("No product found with id : "+productID));

        return product;

    }

    @Override
    public Product reduceQuantity(Integer productID, Integer quantity) throws CustomException {

        Product product = productRepo.findById(productID).orElseThrow(()->new CustomException("No product found with id : "+productID));

        if(quantity>product.getQuantity())
        {
            throw new CustomException("Product does not have sufficient quantity");
        }

        product.setQuantity(product.getQuantity()-quantity);

        return productRepo.save(product);

    }


}
