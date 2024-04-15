package northwindProject.demo.business.abstracts;

import northwindProject.demo.core.utilities.results.DataResult;
import northwindProject.demo.core.utilities.results.Result;
import northwindProject.demo.entities.concretes.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public
interface ProductService {
    DataResult<List<Product>> getAll();
    Result add( Product product);
}
