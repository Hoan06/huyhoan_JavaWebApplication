package demo.bai1.session01.bai1BTVN;

public class Text {
//    Cách viết này làm mất tính linh hoạt vì:
//
//    Class tự tạo dependency → vi phạm IoC
//    Gây tight coupling
//    Khó mở rộng, khó bảo trì, khó test

//    public RechargeService(PaymentGateway gateway) {
//        this.gateway = gateway;
//    }

//    Muốn dùng Momo/ZaloPay chỉ cần inject vào
//    Không cần sửa class
}
