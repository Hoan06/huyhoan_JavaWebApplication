package ra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.model.entity.VoucherUsage;

public interface VoucherUsageRepository extends JpaRepository<VoucherUsage, Long> {
    boolean existsByUserIdAndVoucherId(Long userId, Long voucherId);
}
