package ra.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ra.model.entity.Product;
import ra.repository.ProductRepository;
import ra.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> getProductsByProducerAndPriceAndSorting(String producer, Double min, Double max, String sortBy, String orderBy, Integer page, Integer itemPerPage) {
        producer = (producer == null) ? "" : producer;
        min = (min == null) ? 0 : min;
        max = (max == null) ? Double.MAX_VALUE : max;

        Sort sort = Sort.by(sortBy != null ? sortBy : "proName");
        sort = "desc".equalsIgnoreCase(orderBy) ? sort.descending() : sort.ascending();

        Pageable pageable = PageRequest.of(page - 1, itemPerPage, sort);

        return productRepository
                .findProductsByProducerContainingAndPriceBetween(producer, min, max, pageable);
    }
}