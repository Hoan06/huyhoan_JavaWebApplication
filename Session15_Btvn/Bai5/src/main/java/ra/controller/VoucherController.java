package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ra.service.VoucherService;

@Controller
public class VoucherController {
    @Autowired
    private VoucherService voucherService;

    @PostMapping("/apply-voucher")
    public String applyVoucher(@RequestParam String code, RedirectAttributes redirectAttributes) {
        Long currentUserId = 1L;

        try {
            voucherService.applyVoucher(currentUserId, code);
            redirectAttributes.addFlashAttribute("success", "Áp dụng mã thành công!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }

        return "redirect:/cart";
    }
}