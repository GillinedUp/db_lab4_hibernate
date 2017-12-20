import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int dbID;

    private String ProductName;
    private int UnitsOnStock;

    public Product() {}

    public Product(String productName, int unitsOnStock) {
        this.ProductName = productName;
        this.UnitsOnStock = unitsOnStock;
    }

    public String getProductName() {
        return ProductName;
    }

    public int getUnitsOnStock() {
        return UnitsOnStock;
    }
}
