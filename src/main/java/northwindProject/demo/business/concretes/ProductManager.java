package northwindProject.demo.business.concretes;

import java.util.List;

import northwindProject.demo.core.utilities.results.DataResult;
import northwindProject.demo.core.utilities.results.Result;
import northwindProject.demo.core.utilities.results.SuccessDataResult;
import northwindProject.demo.core.utilities.results.SuccessResult;
import northwindProject.demo.dataAccess.abstracts.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import northwindProject.demo.business.abstracts.ProductService;
import northwindProject.demo.entities.concretes.Product;

@Service
public
class ProductManager implements ProductService {
    @Autowired
    private
    ProductDao productDao;



    @Override
    public
    DataResult<List<Product>> getAll () {
        return new SuccessDataResult<List<Product>> (productDao.findAll ( ) ,"işlem başarılı"   );
    }

    @Override
    public
    Result add ( Product product ) {
        productDao.save ( product );
        return new SuccessResult ( "Ürün eklendi" );
    }
}
