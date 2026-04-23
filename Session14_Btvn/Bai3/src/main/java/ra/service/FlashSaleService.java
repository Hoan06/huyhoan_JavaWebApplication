package ra.service;

import jakarta.persistence.LockModeType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.entity.Order;
import ra.model.entity.Product;

import java.util.Date;

@Service
public class FlashSaleService {
    @Autowired
    private SessionFactory sessionFactory;

    public String buyNow(Long customerId, Long productId, int quantity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();


            Product product = session.find(Product.class, productId, LockModeType.PESSIMISTIC_WRITE);

            if (product == null) {
                return "Sản phẩm không tồn tại!";
            }

            if (product.getStock() < quantity) {
                return "Hết hàng! Rất tiếc, iPhone 15 đã được bán hết.";
            }

            product.setStock(product.getStock() - quantity);
            session.merge(product);

            Order order = new Order();
            order.setCustomerId(customerId);
            order.setProductId(productId);
            order.setQuantity(quantity);
            order.setStatus("SUCCESS");
            order.setCreatedAt(new Date());
            session.persist(order);

            transaction.commit();
            return "Chúc mừng! Bạn đã đặt hàng thành công iPhone 15.";

        } catch (org.hibernate.PessimisticLockException e) {
            if (transaction != null) transaction.rollback();
            return "Hệ thống đang bận do lượng truy cập quá lớn, vui lòng thử lại sau giây lát!";
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return "Đã xảy ra lỗi hệ thống: " + e.getMessage();
        } finally {
            session.close();
        }
    }
}