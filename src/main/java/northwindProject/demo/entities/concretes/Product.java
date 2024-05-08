package northwindProject.demo.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public
class Product {

    @Column(name = "product_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//   @Column(name = "category_id") //joincolumn sonrası gerek kalmadı
//    private int categoryId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "units_in_stock")
    private short unitsInStock;

    @Column(name = "quantity_per_unit")
    private String quantityPerUnit;

    @Column(name ="unit_price")
    private int unitPrice;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;
}
