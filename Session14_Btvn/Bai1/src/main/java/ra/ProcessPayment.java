package ra;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.entity.Order;
import ra.model.entity.Wallet;

@Service
public class ProcessPayment {
    @Autowired
    private SessionFactory sessionFactory;

    public void processPayment(Long orderId, Long walletId, double totalAmount) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            Order order = session.find(Order.class, orderId);
            if (order == null) throw new Exception("Đơn hàng không tồn tại!");

            order.setStatus("PAID");
            session.merge(order);

            if (true) throw new RuntimeException("Kết nối đến cổng thanh toán thất bại!");

            Wallet wallet = session.find(Wallet.class, walletId);
            if (wallet == null) throw new Exception("Ví không tồn tại!");
            if (wallet.getBalance() < totalAmount) {
                throw new RuntimeException("Số dư không đủ!");
            }

            wallet.setBalance(wallet.getBalance() - totalAmount);
            session.merge(wallet);

            transaction.commit();
            System.out.println("Thanh toán thành công!");

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Lỗi hệ thống, giao dịch đã được hoàn tác: " + e.getMessage());
        } finally {
            session.close();
        }
    }
}
