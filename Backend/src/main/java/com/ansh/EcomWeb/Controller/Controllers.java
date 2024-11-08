package com.ansh.EcomWeb.Controller;

import com.ansh.EcomWeb.Model.Product;
import com.ansh.EcomWeb.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class Controllers {

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public List<Product> Listing(){
        return service.listAllProducts();
    }

}
