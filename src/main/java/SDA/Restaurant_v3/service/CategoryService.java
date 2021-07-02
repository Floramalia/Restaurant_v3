package SDA.Restaurant_v3.service;

import SDA.Restaurant_v3.entities.CategoryModel;
import SDA.Restaurant_v3.entities.ProductModel;
import SDA.Restaurant_v3.repository.CategoryRepository;
import SDA.Restaurant_v3.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    public void addCategory(CategoryModel categoryModel){
        categoryRepository.save(categoryModel);
    }

    public void addProduct(long idProduct, long idCategory) {
        Optional<CategoryModel> categoryModelOptional = categoryRepository.findById(idCategory);
        if(!categoryModelOptional.isPresent()){
            throw new RuntimeException("Category doesn't exist!");
        }
        CategoryModel categoryModel = categoryModelOptional.get();
        Optional<ProductModel> optionalProductModel = productRepository.findById(idProduct);
        if(!optionalProductModel.isPresent()){
            throw  new RuntimeException("Product doesn't exist!");
        }
        ProductModel productModel = optionalProductModel.get();
        List<ProductModel> productFromCategory = categoryModel.getProductModelList();
        productFromCategory.add(productModel);
        categoryRepository.save(categoryModel);
    }
}
