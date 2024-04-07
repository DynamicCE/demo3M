package northwindProject.demo.entities.concretes;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public
class Product {

    @Column(name = "product_id")
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "category_id")
    private int categoryId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "units_in_stock")
    private short unitsInStock;
    @Column(name = "quantity_per_unit")
    private String quantityPerUnit;


    public
    Product () {
    }

    public
    Product ( int id, int categoryId, String productName, short unitsInStock, String quantityPerUnit ) {
        this.id = id;
        this.categoryId = categoryId;
        this.productName = productName;
        this.unitsInStock = unitsInStock;
        this.quantityPerUnit = quantityPerUnit;
    }
}
