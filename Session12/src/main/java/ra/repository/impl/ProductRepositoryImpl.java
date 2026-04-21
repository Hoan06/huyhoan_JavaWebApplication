package ra.repository.impl;

import org.springframework.stereotype.Repository;
import ra.model.dto.Product;
import ra.repository.ProductRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private List<Product> products;

    public ProductRepositoryImpl() throws ParseException {
        products = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        products.add(new Product("P01" , "Sản phẩm 1" , "Dell" , 2025 , sdf.parse("21/12/2025"), 133131.22));
    }

    @Override
    public List<Product> findAll() {
        return List.of();
    }
}
