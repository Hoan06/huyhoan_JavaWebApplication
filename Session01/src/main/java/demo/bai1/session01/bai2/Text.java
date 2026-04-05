package demo.bai1.session01.bai2;

public class Text {
//    Bean PlaySession gây lỗi vì:
//
//    Spring chỉ tạo 1 instance duy nhất (Singleton)
//    Mọi máy trạm dùng chung → chia sẻ biến playTime
//    Làm cho thời gian chơi bị cộng dồn sai giữa các user

//    Nên dùng protopyte
//    Mỗi lần request → tạo object mới
//    Mỗi user có session riêng
}
