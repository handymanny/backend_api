package Controller;


import Model.Category;
import Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllCategories(@RequestParam(required = false, defaultValue = "name") String order,
                                           @RequestParam(required = false, defaultValue = "1") Integer page,
                                           @RequestParam(required = false, defaultValue = "20") Integer limit) {
        return new ResponseEntity<>(categoryService.getAllCategories(order, page, limit), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Category getCategoriesById(@PathVariable("id")int id) {
        return categoryService.getCategoriesById(id);
    }

    @RequestMapping(value = "/inProduct/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Category> getCategoriesOfProduct(@PathVariable("id") Integer productId) {
        return categoryService.getCategoriesOfProduct(productId);
    }

    @RequestMapping(value = "/inDepartment/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Category> getCategoriesOfDepartment(@PathVariable("id") Integer departmentId) {
        return categoryService.getCategoriesOfDepartment(departmentId);
    }
}
