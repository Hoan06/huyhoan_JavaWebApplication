package ra.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.entity.User;
import ra.model.entity.Voucher;
import ra.model.entity.VoucherUsage;
import ra.repository.VoucherRepository;
import ra.repository.VoucherUsageRepository;

import java.time.LocalDateTime;

@Service
public class VoucherService {
    @Autowired private VoucherRepository voucherRepository;
    @Autowired
    private VoucherUsageRepository usageRepository;

    @Transactional
    public void applyVoucher(Long userId, String voucherCode) {
        Voucher voucher = voucherRepository.findByCodeWithLock(voucherCode)
                .orElseThrow(() -> new RuntimeException("Mã giảm giá không tồn tại"));

        if (!"ACTIVE".equals(voucher.getStatus()) || voucher.getExpiryDate().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Mã giảm giá đã hết hạn hoặc bị vô hiệu hóa");
        }

        if (usageRepository.existsByUserIdAndVoucherId(userId, voucher.getId())) {
            throw new RuntimeException("Bạn đã sử dụng mã này rồi");
        }

        if (!voucher.hasStock()) {
            throw new RuntimeException("Mã giảm giá đã hết lượt sử dụng");
        }

        voucher.setUsedCount(voucher.getUsedCount() + 1);
        voucherRepository.save(voucher);

        VoucherUsage usage = new VoucherUsage();
        usage.setUser(new User(userId));
        usage.setVoucher(voucher);
        usage.setAppliedAt(LocalDateTime.now());
        usageRepository.save(usage);
    }
}