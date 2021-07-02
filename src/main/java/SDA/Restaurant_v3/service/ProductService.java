package SDA.Restaurant_v3.service;

import SDA.Restaurant_v3.entities.ProductModel;
import SDA.Restaurant_v3.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void addProduct(ProductModel productModel){
        productRepository.save(productModel);
    }
}
