package ra.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ra.model.entity.Order;
import ra.model.entity.Product;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StockCleanupService {
    @Autowired
    private SessionFactory sessionFactory;

    @Scheduled(fixedRate = 60000)
    public void releaseExpiredStock() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            String hql = "FROM Order o WHERE o.status = 'PENDING' AND o.expireAt < :now";
            List<Order> expiredOrders = session.createQuery(hql, Order.class)
                    .setParameter("now", LocalDateTime.now())
                    .list();

            for (Order order : expiredOrders) {
                Product product = session.find(Product.class, order.getProductId());

                if (product != null) {
                    product.setStock(product.getStock() + order.getQuantity());
                    session.merge(product);
                }

                order.setStatus("EXPIRED");
                session.merge(order);
            }

            transaction.commit();
            if(!expiredOrders.isEmpty()) {
                System.out.println("Đã hoàn kho cho " + expiredOrders.size() + " đơn hàng hết hạn.");
            }

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Lỗi khi hoàn kho tự động: " + e.getMessage());
        } finally {
            session.close();
        }
    }
}