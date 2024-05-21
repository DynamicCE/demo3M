package northwindProject.demo.business.concretes;

import java.util.List;

import northwindProject.demo.core.utilities.results.DataResult;
import northwindProject.demo.core.utilities.results.Result;
import northwindProject.demo.core.utilities.results.SuccessDataResult;
import northwindProject.demo.core.utilities.results.SuccessResult;
import northwindProject.demo.dataAccess.abstracts.ProductDao;
import northwindProject.demo.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import northwindProject.demo.business.abstracts.ProductService;
import northwindProject.demo.entities.concretes.Product;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

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
    DataResult<List<Product>> getAll ( int pageNo, int pageSize ) {
        Pageable pageable = PageRequest.of ( pageNo-1,pageSize);
        return new SuccessDataResult<List<Product>>
                (this.productDao.findAll(pageable).getContent());
    }

    @Override
    public
    DataResult<List<Product>> getAllSorted () {
        Sort sort = Sort.by(Sort.Direction.DESC,"productName");
        return new SuccessDataResult<List<Product>>(productDao.findAll ( sort ),"başarılı ");
    }

    @Override
    public
    Result add ( Product product ) {
        productDao.save ( product );
        return new SuccessResult ( "Ürün eklendi" );
    }

    @Override
    public
    DataResult<Product> getByProductName ( String productName ) {
        return new SuccessDataResult<Product> (productDao.getByProductName ( productName ) ,"veri listelendi"   );
    }

    @Override
    public
    DataResult<Product> getByProductNameAndCategoryId ( String productName, int categoryId ) {
        // iş kodları

        return new SuccessDataResult<Product> ( productDao.getByProductNameAndCategory_CategoryId ( productName,categoryId ),"veri listelendi" );
    }

    @Override
    public
    DataResult<List<Product>> getByProductNameOrCategoryId ( String productName, int categoryId ) {
        return new SuccessDataResult<List<Product>> ( productDao.getByProductNameOrCategory_CategoryId ( productName,categoryId ),"veri listelendi");
    }

    @Override
    public
    DataResult<List<Product>> getByCategoryIdIn ( List<Integer> categories ) {
        return new SuccessDataResult<List<Product>>(productDao.getByCategoryIn ( categories ),"veri listelendi");
    }

    @Override
    public
    DataResult<List<Product>> getByProductNameContains ( String productName ) {
        return new SuccessDataResult<List<Product>> (productDao.getByProductNameContains ( productName ),"veri listelendi");
    }

    @Override
    public
    DataResult<List<Product>> getByProductNameStartsWith ( String productName ) {
        return new SuccessDataResult<List<Product>> ( productDao.getByProductNameStartsWith ( productName ),"veri listelendi" );
    }

    @Override
    public
    DataResult<List<Product>> getByProductNameEndsWith ( String productName ) {
        return new SuccessDataResult<List<Product>> (productDao.getByProductNameEndsWith ( productName ),"veri listelendi" );
    }

    @Override
    public
    DataResult<List<Product>> getByNameAndCategory ( String productName, int categoryId ) {
        return new SuccessDataResult<List<Product>> ( productDao.getByNameAndCategory ( productName,categoryId),"veri listelendi"  );
    }

    @Override
    public
    DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails () {
        return new SuccessDataResult<List<ProductWithCategoryDto>> ( productDao.getProductWithCategoryDetails (),"işlem başarılı" );
    }
}
