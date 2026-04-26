package sesison15.bai3;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Page<Order> findByUserIdAndStatus(Long userId, String status, Pageable pageable);

    Page<Order> findByUserId(Long userId, Pageable pageable);
}