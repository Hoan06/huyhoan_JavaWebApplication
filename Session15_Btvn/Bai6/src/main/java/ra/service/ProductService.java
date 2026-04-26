package ra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ra.model.entity.Product;
import ra.model.entity.ProductSpecifications;
import ra.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Page<Product> getBestSellers(int page, int size) {
        int safePage = Math.max(page, 0);
        Pageable pageable = PageRequest.of(safePage, size, Sort.by("price").descending());
        return productRepository.findBestSellers(pageable);
    }

    public List<Product> searchSmart(String name, Double min, Double max) {
        if (min != null && max != null && min > max) {
            throw new IllegalArgumentException("Khoảng giá tìm kiếm không hợp lệ!");
        }
        return productRepository.findAll(ProductSpecifications.filterProducts(name, min, max));
    }
}