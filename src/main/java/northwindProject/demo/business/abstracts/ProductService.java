package northwindProject.demo.business.abstracts;

import northwindProject.demo.core.utilities.results.DataResult;
import northwindProject.demo.core.utilities.results.Result;
import northwindProject.demo.entities.concretes.Product;
import northwindProject.demo.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.List;
@Service
public
interface ProductService {
    DataResult<List<Product>> getAll();

    DataResult<List<Product>> getAll(int pageNo,int pageSize);

    DataResult<List<Product>> getAllSorted();

    Result add( Product product);

    DataResult<Product> getByProductName(String productName);

    DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId);

    DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);

    DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);

    DataResult<List<Product>> getByProductNameContains(String productName);

    DataResult<List<Product>> getByProductNameStartsWith(String productName);

    DataResult<List<Product>> getByProductNameEndsWith(String productName);

    DataResult<List<Product>> getByNameAndCategory( String productName, int categoryId );

    DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();

}
