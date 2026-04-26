package ra.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ra.model.entity.Product;

public interface ProductService {
    Page<Product> getProductsByProducerAndPriceAndSorting(String producer , Double min , Double max , String sortBy , String orderBy , Integer page , Integer itemPerPage);


}
