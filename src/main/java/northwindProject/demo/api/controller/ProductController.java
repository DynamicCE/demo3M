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
@RequestMapping("/api/products")
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
}

