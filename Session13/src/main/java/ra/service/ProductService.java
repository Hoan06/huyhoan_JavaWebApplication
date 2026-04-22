package ra.service;

import org.springframework.beans.factory.annotation.Autowired;
import ra.model.entity.Product;
import ra.repository.ProductRepository;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product insertProduct(Product product);
    List<Product> findByProductName(String productName);
}
