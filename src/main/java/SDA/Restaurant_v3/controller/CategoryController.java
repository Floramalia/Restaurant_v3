package SDA.Restaurant_v3.controller;

import SDA.Restaurant_v3.entities.CategoryModel;
import SDA.Restaurant_v3.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("addCategory")
    public void addCategory(@RequestBody CategoryModel categoryModel) {
        categoryService.addCategory(categoryModel);
    }

    @PutMapping("addProductToCategory/{idProduct}/{idCategory}")
    public void addProductToCategory(@PathVariable long idProduct, @PathVariable long idCategory) {
        categoryService.addProduct(idProduct, idCategory);
    }
}
