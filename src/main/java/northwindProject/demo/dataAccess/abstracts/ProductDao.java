package northwindProject.demo.dataAccess.abstracts;

import java.util.List;

import northwindProject.demo.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import northwindProject.demo.entities.concretes.Product;
import org.springframework.data.jpa.repository.Query;

public interface ProductDao extends JpaRepository<Product, Integer> {
    Product getByProductName(String productName);

    Product getByProductNameAndCategoryId(String productName, int categoryId);

    List<Product> getByProductNameOrCategoryId(String productName, int categoryId);

    List<Product> getByCategoryIdIn(List<Integer> categories);

    List<Product> getByProductNameContains(String productName);

    List<Product> getByProductNameStartsWith(String productName);

    List<Product> getByProductNameEndsWith(String productName);
   @Query("From Product where productName=:productName and categoryId =: categoryId") //entity tablo isimleri ,db değil
    List<Product> getByNameAndCategory( String productName, int categoryId );
}
