package ra.repository;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import ra.model.entity.Voucher;

import java.time.LocalDateTime;
import java.util.Optional;

public interface VoucherRepository extends JpaRepository<Voucher, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT v FROM Voucher v WHERE v.code = :code")
    Optional<Voucher> findByCodeWithLock(String code);

    boolean existsByCodeAndStatusAndExpiryDateAfter(String code, String status, LocalDateTime now);
}

