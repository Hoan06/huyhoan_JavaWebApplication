package ra.repository;

import ra.model.entity.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    Product insert(Product product);
    List<Product> findBySearchName(String proName);
}
