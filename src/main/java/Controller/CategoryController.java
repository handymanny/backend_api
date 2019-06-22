package Controller;


import Model.Category;
import Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController (CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllCategories(@RequestParam(required = false) String order,
                                           @RequestParam(required = false) int page,
                                           @RequestParam(required = false) int limit) {
        return new ResponseEntity<>(categoryService.getAllCategories(order, page, limit), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Category getCategoriesById(@PathVariable("id")int id) {
        return categoryService.getCategoriesById(id);
    }

    @RequestMapping(value = "/inProduct/{id}", method = RequestMethod.GET)
    public List<Category> getCategoriesOfProduct(@PathVariable("id") int productId) {
        return categoryService.getCategoriesOfProduct(productId);
    }

    @RequestMapping(value = "/inDepartment/{id}", method = RequestMethod.GET)
    public List<Category> getCategoriesOfDepartment(@PathVariable("id") int departmentId) {
        return categoryService.getCategoriesOfDepartment(departmentId);
    }
}
