package ra.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.entity.TransactionHistory;
import ra.model.entity.Wallet;


@Service
public class WalletService {
    @Autowired
    private SessionFactory sessionFactory;

    public void rechargeMoney(Long walletId, Double amount) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            System.out.println("--- Kiểm tra Cache lần 1 ---");
            Wallet wallet = session.find(Wallet.class, walletId);

            System.out.println("--- Kiểm tra Cache lần 2 (Không nên thấy SELECT) ---");
            session.find(Wallet.class, walletId);

            wallet.setBalance(wallet.getBalance() + amount);

            TransactionHistory history = new TransactionHistory();
            history.setAmount(amount);
            history.setDescription("Nạp tiền: +" + amount);
            history.setWallet(wallet);

            session.persist(history);
            transaction.commit();
            System.out.println("Thành công!");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void transferMoney(Long fromId, Long toId, Double amount) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Wallet from = session.find(Wallet.class, fromId);
            Wallet to = session.find(Wallet.class, toId);

            if (from.getBalance() < amount) throw new RuntimeException("Số dư không đủ!");

            from.setBalance(from.getBalance() - amount);
            session.merge(from);

            System.out.println("Đang giả lập lỗi chia cho 0...");
            int bug = 10 / 0;

            to.setBalance(to.getBalance() + amount);
            session.merge(to);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Giao dịch thất bại, đã Rollback: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    public void showWalletInfo(Long walletId) {
        Session session = null;
        try {
            String hql = "SELECT w FROM Wallet w LEFT JOIN FETCH w.histories WHERE w.id = :id";
            Wallet wallet = session.createQuery(hql, Wallet.class)
                    .setParameter("id", walletId)
                    .getSingleResult();

            session.close();

            System.out.println("Chủ ví: " + wallet.getOwnerName() + " | Số dư: " + wallet.getBalance());
            System.out.println("Lịch sử giao dịch:");
            wallet.getHistories().forEach(h ->
                    System.out.println("- " + h.getDescription() + " (" + h.getAmount() + ")")
            );
        } catch (Exception e) {
            System.err.println("Lỗi truy xuất: " + e.getMessage());
        }
    }
}