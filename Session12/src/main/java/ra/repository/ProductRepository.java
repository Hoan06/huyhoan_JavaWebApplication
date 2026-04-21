package ra.repository;


import ra.model.dto.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
}
