package northwindProject.demo.api.controller;

import northwindProject.demo.business.abstracts.ProductService;
import northwindProject.demo.core.utilities.results.DataResult;
import northwindProject.demo.core.utilities.results.Result;
import northwindProject.demo.core.utilities.results.SuccessResult;
import northwindProject.demo.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products/")
public
class ProductController {

    private
    ProductService productService;

    public
    ProductController ( ProductService productService ) {
        this.productService = productService;
    }

    @GetMapping("/getall")
    public
    DataResult<List<Product>> getAll () {
        return productService.getAll ( );
    }

    @PostMapping({"/add"})
    public
    Result add ( @RequestBody Product product ) {
        return productService.add ( product );
    }
    @GetMapping("getByProductName")

    public DataResult<Product> getByProductName(@RequestParam String productName){
        return productService.getByProductName ( productName );
    }
    @GetMapping("getByProductNameAndCategory")
    public DataResult<Product> getByProductNameAndCategory(String productName,int categoryId){
        return productService.getByProductNameAndCategory ( productName,categoryId );
    }
    @GetMapping("getByProductNameOrCategory")
    public DataResult<List<Product>> getByProductNameOrCategory(String productName,int categoryId){
        return productService.getByProductNameOrCategory ( productName,categoryId );
    }
    @GetMapping("getByCategoryIn")
    public DataResult<List<Product>> getByCategoryIn(List<Integer> categories){
        return productService.getByCategoryIn ( categories );
    }
    @GetMapping("getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(String productName){
        return productService.getByProductNameContains ( productName );
    }

    @GetMapping("getByProductNameStartsWith")
    public DataResult<List<Product>> getByProductNameStartsWith(String productName){
        return productService.getByProductNameStartsWith ( productName );
    }

    @GetMapping("getByProductNameEndsWith")
    public DataResult<List<Product>> getByProductNameEndsWith(String productName){
        return productService.getByProductNameEndsWith ( productName );
    }

    @GetMapping("getByNameAndCategory")
    public DataResult<List<Product>> getByNameAndCategory( String productName, int categoryId ){
        return productService.getByNameAndCategory ( productName,categoryId );
    }
}

