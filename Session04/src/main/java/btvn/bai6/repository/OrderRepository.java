package btvn.bai6.repository;

import org.springframework.stereotype.Repository;

@Repository("bai6OrderRepository")
public class OrderRepository {
    public String findById(Long id) {
        return "Thông tin chi tiết của đơn hàng #" + id;
    }

    public String save() {
        return "Đơn hàng mới đã được lưu vào Database!";
    }

    public String delete(Long id) {
        return "Đơn hàng #" + id + " đã được xóa khỏi hệ thống!";
    }
}
