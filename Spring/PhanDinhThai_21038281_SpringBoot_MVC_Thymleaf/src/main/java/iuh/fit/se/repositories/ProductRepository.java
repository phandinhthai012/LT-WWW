package iuh.fit.se.repositories;

import iuh.fit.se.enities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Page<Product> findAll(Pageable pageable);
    @Query("SELECT p FROM Product p WHERE p.name LIKE %:keyword%"
        + " OR p.category.name LIKE %:keyword%"
        + " OR p.code LIKE %:keyword%"
        + " OR p.description LIKE %:keyword%"
    )
    List<Product> search(@Param("keyword") String keyword);

    List<Product> findByPrice(double price);

    List<Product> findByRegisterDate(Date registerDate);

    List<Product> findByCategory_Id(int categoryId);

}
