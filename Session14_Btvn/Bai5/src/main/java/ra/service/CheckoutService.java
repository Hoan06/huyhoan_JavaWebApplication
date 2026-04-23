package ra.service;

import jakarta.persistence.LockModeType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.dto.CartItem;
import ra.model.entity.Product;
import ra.model.entity.Vendor;
import ra.model.entity.Wallet;

import java.util.List;

@Service
public class CheckoutService {
    @Autowired
    private SessionFactory sessionFactory;

    public void processMultiVendorOrder(Long customerId, List<CartItem> items) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            double totalOrderAmount = 0;
            Wallet wallet = session.find(Wallet.class, customerId);

            for (CartItem item : items) {
                Product product = session.find(Product.class, item.getProductId(), LockModeType.PESSIMISTIC_WRITE);

                if (product == null || product.getStock() < item.getQuantity()) {
                    throw new Exception("Sản phẩm " + (product != null ? product.getName() : "ID " + item.getProductId()) + " không đủ hàng!");
                }

                double subTotal = product.getPrice() * item.getQuantity();
                totalOrderAmount += subTotal;

                product.setStock(product.getStock() - item.getQuantity());
                Vendor vendor = product.getVendor();
                vendor.setRevenue(vendor.getRevenue() + subTotal);

                session.merge(product);
                session.merge(vendor);
            }

            if (wallet.getBalance() < totalOrderAmount) {
                throw new Exception("Số dư ví không đủ để thanh toán toàn bộ đơn hàng!");
            }
            wallet.setBalance(wallet.getBalance() - totalOrderAmount);
            session.merge(wallet);

            transaction.commit();
            System.out.println(">>> THANH TOÁN THÀNH CÔNG: Đã trừ " + totalOrderAmount + " từ ví.");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.err.println(">>> GIAO DỊCH THẤT BẠI (ROLLBACK): " + e.getMessage());
        } finally {
            session.close();
        }
    }
}
