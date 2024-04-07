package northwindProject.demo.business.abstracts;

import northwindProject.demo.entities.concretes.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public
interface ProductService {
    List<Product> getAll();
}
