package ra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ra.service.WalletService;

import java.util.Scanner;

@SpringBootApplication
public class Bai6Application {

    public static void main(String[] args) {
        WalletService service = new WalletService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n========== WALLET CONSOLE ==========");
            System.out.println("1. Nạp tiền (Demo Cache)");
            System.out.println("2. Chuyển tiền (Demo Rollback)");
            System.out.println("3. Xem thông tin & Lịch sử (Demo Join Fetch)");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        System.out.print("ID Ví: "); Long id = Long.parseLong(sc.nextLine());
                        System.out.print("Số tiền: "); Double amt = Double.parseDouble(sc.nextLine());
                        service.rechargeMoney(id, amt);
                        break;
                    case 2:
                        System.out.print("Từ ID ví: "); Long from = Long.parseLong(sc.nextLine());
                        System.out.print("Đến ID ví: "); Long to = Long.parseLong(sc.nextLine());
                        System.out.print("Số tiền: "); Double tAmt = Double.parseDouble(sc.nextLine());
                        service.transferMoney(from, to, tAmt);
                        break;
                    case 3:
                        System.out.print("ID Ví: "); Long viewId = Long.parseLong(sc.nextLine());
                        service.showWalletInfo(viewId);
                        break;
                    case 0:
                        System.exit(0);
                }
            } catch (Exception e) {
                System.err.println("Lỗi: " + e.getMessage());
            }
        }
    }

}
