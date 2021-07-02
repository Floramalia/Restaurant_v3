package SDA.Restaurant_v3.controller;

import SDA.Restaurant_v3.entities.ProductModel;
import SDA.Restaurant_v3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("addProduct")
    public void addProduct(ProductModel productModel){
        productService.addProduct(productModel);
    }
}
