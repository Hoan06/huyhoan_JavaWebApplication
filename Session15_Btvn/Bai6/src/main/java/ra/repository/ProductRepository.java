package ra.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ra.model.dto.ProductSlimDTO;
import ra.model.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    List<Product> findByCategoryAndStatusTrue(String category);

    @Query("SELECT p FROM Product p WHERE p.status = true")
    Page<Product> findBestSellers(Pageable pageable);

    @Query("SELECT p.productName as productName, p.price as price FROM Product p WHERE p.id = :id")
    ProductSlimDTO findSlimById(Long id);
}
