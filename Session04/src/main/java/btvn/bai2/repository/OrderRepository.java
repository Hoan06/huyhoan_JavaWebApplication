package btvn.bai2.repository;

import org.springframework.stereotype.Repository;

@Repository("bai2OrderRepository")
public class OrderRepository {
    public String getAllOrders() {
        return "Danh sach toan bo don hang (Spring Managed)";
    }

    public String getOrderById(Long id) {
        return "Thong tin don hang voi ID: " + id;
    }
}
