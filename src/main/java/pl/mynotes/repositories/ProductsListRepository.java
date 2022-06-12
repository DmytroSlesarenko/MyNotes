package pl.mynotes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mynotes.models.ProductsList;

public interface ProductsListRepository extends JpaRepository<ProductsList, Long> {
}
