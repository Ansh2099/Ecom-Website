package com.ansh.EcomWeb.Service;

import com.ansh.EcomWeb.Model.Product;
import com.ansh.EcomWeb.Repositery.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProduct(int id) {
        return repo.findById(id).orElse(null);
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());

        return repo.save(product);
    }


    public Product updateProduct(Product product, MultipartFile imageFile) throws IOException {
        
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageData(imageFile.getBytes());
        product.setImageType(imageFile.getContentType());
        
        return repo.save(product);
    }

    public void deleteProduct(int id) {
         repo.deleteById(id);
    }

    public List<Product> searchfunction(String keyword) {
        return repo.searchByKeyword(keyword);
    }
}