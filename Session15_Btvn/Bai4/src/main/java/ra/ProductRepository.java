package ra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    long countByCategoryNameAndStatus(String categoryName, String status);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Product p SET p.price = p.price * (1 - :discount / 100) " +
            "WHERE p.category.name = :categoryName AND p.status = 'ACTIVE'")
    int bulkUpdatePriceByCategory(@Param("categoryName") String categoryName,
                                  @Param("discount") Double discount);
}