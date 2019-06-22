package Controller;

import Model.Product;
import Model.ProductLocation;
import Model.Review;
import Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllProducts (@RequestParam(required = false, defaultValue = "1") Integer page,
                                          @RequestParam(required = false, defaultValue = "20") Integer limit,
                                          @RequestParam(required = false, defaultValue = "200") Integer descLength) {
        return new ResponseEntity<>(productService.getAllProducts(page, limit, descLength), HttpStatus.OK);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ResponseEntity<Object> searchProducts(@RequestParam("query_string") String query,
                                        @RequestParam(required = false, defaultValue = "on") String allWords,
                                        @RequestParam(required = false, defaultValue = "1") Integer page,
                                        @RequestParam(required = false, defaultValue = "20") Integer limit,
                                        @RequestParam(required = false, defaultValue = "200") Integer descLength){
        return new ResponseEntity<>(productService.searchProducts(query, allWords, page, limit, descLength), HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable("id") Integer id) {
        return productService.getProduct(id);
    }


    @RequestMapping(value = "/inCategory/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getProductsInCategory(@PathVariable("id") Integer categoryId,
                                               @RequestParam(required = false, defaultValue = "1") Integer page,
                                               @RequestParam(required = false, defaultValue = "20") Integer limit,
                                               @RequestParam(required = false, defaultValue = "200") Integer descLength) {
     return new ResponseEntity<>(productService.getProductsInCategory(categoryId, page, limit, descLength), HttpStatus.OK);
    }


    @RequestMapping(value = "/inDepartment/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getProductsInDepartment(@PathVariable("id") Integer departmentId,
                                                 @RequestParam(required = false, defaultValue = "1") Integer page,
                                                 @RequestParam(required = false, defaultValue = "20") Integer limit,
                                                 @RequestParam(required = false, defaultValue = "200") Integer descLength) {
        return new ResponseEntity<>(productService.getProductsInDepartment(departmentId, page, limit, descLength), HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}/details", method = RequestMethod.GET)
    public Product getProductDetails(@PathVariable("id") Integer id) {
        return productService.getProductDetails(id);
    }

    @RequestMapping(value = "/{id}/locations", method = RequestMethod.GET)
    public ProductLocation getProductLocations(@PathVariable("id") Integer id) {
        return productService.getProductLocations(id);
    }


    @RequestMapping(value = "/{id}/reviews", method = RequestMethod.GET)
    public List<Review> getProductReviews(@PathVariable("id") Integer id) {
        return productService.getProductReview(id);
    }

    @RequestMapping(value = "/{id}/reviews", method = RequestMethod.POST)
    public void postProductReview(@PathVariable("id") Integer id,
                                  @RequestParam("customer_id") Integer cid,
                                  @RequestParam("review") String review,
                                  @RequestParam("rating") Short rating) {
        productService.postProductReview(cid, id, review, rating);
    }
}
