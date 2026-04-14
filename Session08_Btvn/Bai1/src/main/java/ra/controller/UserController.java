package ra.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ra.model.dto.AddressDto;

@Controller
@RequestMapping("/api/address")
public class UserController {
    @PostMapping("/update")
    public ResponseEntity<String> updateAddress(@Valid @RequestParam("address") AddressDto addressDto) {
        // Logic lưu database ở đây
        return ResponseEntity.ok("Cập nhật địa chỉ thành công !");
    }
}
