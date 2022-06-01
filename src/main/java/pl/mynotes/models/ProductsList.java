package pl.mynotes.models;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "products_list")
public class ProductsList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 10000)
    private String productsList;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "folder_id")
    private Folder folder;

    @ManyToOne
    @JoinColumn(name = "user_id")
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
