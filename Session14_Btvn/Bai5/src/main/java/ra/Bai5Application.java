package ra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ra.model.dto.CartItem;
import ra.service.CheckoutService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Bai5Application {

    public static void main(String[] args) {
        var context = SpringApplication.run(Bai5Application.class, args);
        CheckoutService checkoutService = context.getBean(CheckoutService.class);

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n========== RIKKEI MALL MANAGEMENT ==========");
            System.out.println("1. Nạp tiền ví");
            System.out.println("2. Xem danh sách sản phẩm & Kho");
            System.out.println("3. Thanh toán đơn hàng đa bên");
            System.out.println("4. Thống kê doanh thu");
            System.out.println("0. Thoát");
            System.out.print("Mời chọn: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 3:
                        System.out.println("--- THANH TOÁN ĐA BÊN ---");
                        List<CartItem> cart = new ArrayList<>();

                        while (true) {
                            System.out.print("Nhập ID sản phẩm (nhập 0 để dừng): ");
                            Long pId = Long.parseLong(sc.nextLine());
                            if (pId == 0) break;

                            System.out.print("Nhập số lượng: ");
                            int qty = Integer.parseInt(sc.nextLine());

                            cart.add(new CartItem(pId, qty));
                        }

                        if (!cart.isEmpty()) {
                            System.out.print("Nhập ID ví khách hàng (ví dụ: 1): ");
                            Long walletId = Long.parseLong(sc.nextLine());

                            System.out.println("Đang thực hiện giao dịch...");
                            checkoutService.processMultiVendorOrder(walletId, cart);
                        } else {
                            System.out.println("Giỏ hàng trống!");
                        }
                        break;
                    case 0:
                        System.exit(0);
                }
            } catch (Exception e) {
                System.err.println("Lỗi nhập liệu hoặc hệ thống: " + e.getMessage());
            }
        }
    }
}