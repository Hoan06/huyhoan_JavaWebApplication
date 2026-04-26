package ra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public String applyMassiveDiscount(String categoryName, Double discountPercentage) {

        if (discountPercentage == null || discountPercentage <= 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Phần trăm giảm giá phải nằm trong khoảng (0 - 100]");
        }

        long count = productRepository.countByCategoryNameAndStatus(categoryName, "ACTIVE");
        if (count == 0) {
            return "Không tìm thấy sản phẩm nào thuộc danh mục '" + categoryName + "' đang kinh doanh để cập nhật.";
        }

        int updatedCount = productRepository.bulkUpdatePriceByCategory(categoryName, discountPercentage);

        return "Cập nhật thành công cho " + updatedCount + " sản phẩm thuộc danh mục " + categoryName;
    }
}
