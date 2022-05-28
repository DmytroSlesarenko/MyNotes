package pl.mynotes.models;

import javax.persistence.*;

@Entity
@Table(name = "products_list")
public class ProductsList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10000)
    private String productsList;

    @ManyToOne
    private Folder folder;

    @ManyToOne
    private User user;

    public ProductsList(Long id, String productsList) {
        this.id = id;
        this.productsList = productsList;
    }

    public ProductsList() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductsList() {
        return productsList;
    }

    public void setProductsList(String productsList) {
        this.productsList = productsList;
    }

    @Override
    public String toString() {
        return "ProductsList{" +
                "id = " + id +
                ", productsList = '" + productsList + '\'' +
                '}';
    }
}
