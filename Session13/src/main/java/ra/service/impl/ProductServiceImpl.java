package ra.service.impl;

import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.entity.Product;
import ra.repository.ProductRepository;
import ra.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product insertProduct(Product product) {
        return productRepository.insert(product);
    }

    @Override
    public List<Product> findByProductName(String proName) {
        if(proName == null || proName.length()==0){
            proName = "%";
        }else{
            proName = "%"+proName+"%";
        }
        return productRepository.findBySearchName(proName);
    }
}
