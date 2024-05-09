package northwindProject.demo.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import northwindProject.demo.entities.concretes.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
    Product getByProductName(String productName);

    Product getByProductNameAndCategory_CategoryId ( String productName, int categoryId);

    List<Product> getByProductNameOrCategory_CategoryId ( String productName, int categoryId);

    List<Product> getByCategoryIn ( List<Integer> categories);

    List<Product> getByProductNameContains(String productName);

    List<Product> getByProductNameStartsWith(String productName);

    List<Product> getByProductNameEndsWith(String productName);
    @Query("From Product where productName=:productName and category.categoryId=:categoryId")//entity tablo isimleri ,db değil
    List<Product> getByNameAndCategory( String productName, int categoryId );
}
