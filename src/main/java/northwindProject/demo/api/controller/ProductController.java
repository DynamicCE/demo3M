package northwindProject.demo.api.controller;

import northwindProject.demo.business.abstracts.ProductService;
import northwindProject.demo.core.utilities.results.DataResult;
import northwindProject.demo.core.utilities.results.Result;
import northwindProject.demo.core.utilities.results.SuccessDataResult;
import northwindProject.demo.core.utilities.results.SuccessResult;
import northwindProject.demo.entities.concretes.Product;
import northwindProject.demo.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
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

    @GetMapping("getall")
    public
    DataResult<List<Product>> getAll () {
        return productService.getAll ( );
    }

    @PostMapping({"add"})
    public
    Result add ( @RequestBody Product product ) {
        return productService.add ( product );
    }

    @GetMapping("getByProductName")
    public DataResult<Product> getByProductName(@RequestParam String productName){
        return productService.getByProductName ( productName );
    }
    @GetMapping("getByProductNameAndCategoryId")
    public DataResult<Product> getByProductNameAndCategoryId(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId){
        return productService.getByProductNameAndCategoryId ( productName,categoryId );
    }
    @GetMapping("getByNameAndCategory")
    public DataResult<List<Product>> getByNameAndCategory( String productName, int categoryId ){
        return productService.getByNameAndCategory ( productName,categoryId );
    }
    @GetMapping("getByProductNameOrCategoryId")
    DataResult<List<Product>> getByProductNameOrCategoryId( @RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId  ){
        return productService.getByProductNameOrCategoryId ( productName,categoryId );
    }
    @GetMapping("getByCategoryIdIn")
    DataResult<List<Product>> getByCategoryIdIn(@RequestParam List<Integer> categories){
        return productService.getByCategoryIdIn ( categories );
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

    @GetMapping("getAllByPage")
    DataResult<List<Product>> getAll(int pageNo , int pageSize){
        return this.productService.getAll (pageNo,pageSize);
    }
    @GetMapping("getAllSorted")
    public
    DataResult<List<Product>> getAllSorted (){
        return productService.getAllSorted ();
    }
    @GetMapping("getProductWithCategoryDetails")
    DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
        return productService.getProductWithCategoryDetails ();
    }
}

