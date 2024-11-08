package com.ansh.EcomWeb.Service;

import com.ansh.EcomWeb.Model.Product;
import com.ansh.EcomWeb.Repositery.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public List<Product> listAllProducts() {
        return repo.findAll();
    }
}
