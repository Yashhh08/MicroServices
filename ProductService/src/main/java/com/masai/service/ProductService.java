package com.masai.service;

import com.masai.exception.*;
import com.masai.model.*;

import java.util.*;

public interface ProductService {

    public Product addProduct(Product product) throws CustomException;

    public String deleteProduct(Integer productID) throws CustomException;

    public List<Product> getAllProducts() throws CustomException;

    public Product findProductById(Integer ProductID) throws CustomException;

    public Product reduceQuantity(Integer productID, Integer quantity) throws CustomException;

}
