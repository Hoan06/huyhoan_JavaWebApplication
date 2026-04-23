package ra.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.entity.Order;
import ra.model.entity.Product;

@Service
public class CancelOrder {
    @Autowired
    private SessionFactory sessionFactory;

    public void cancelOrder(Long orderId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            Order order = session.find(Order.class, orderId);
            if (order == null) {
                throw new Exception("Đơn hàng không tồn tại!");
            }

            order.setStatus("CANCELLED");
            session.merge(order);


            if (order.getProductId() == null) {
                throw new Exception("Dữ liệu sản phẩm trong đơn hàng bị lỗi (Null ID)!");
            }

            Product product = session.find(Product.class, order.getProductId());
            if (product == null) {
                throw new Exception("Sản phẩm không tồn tại trong hệ thống kho!");
            }

            product.setStock(product.getStock() + order.getQuantity());
            session.merge(product);

            transaction.commit();
            System.out.println("Hủy đơn hàng và hoàn kho thành công!");

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Lỗi nghiệp vụ: " + e.getMessage());
        } finally {
            session.close();
        }
    }
}
