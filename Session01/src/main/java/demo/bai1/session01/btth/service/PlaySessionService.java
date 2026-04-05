package demo.bai1.session01.btth.service;

import demo.bai1.session01.btth.notification.NotificationService;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class PlaySessionService {

    private final Map<String, NotificationService> notificationServices;

    public PlaySessionService(Map<String, NotificationService> notificationServices) {
        this.notificationServices = notificationServices;
    }

    public void checkBalance(String username, double balance, String zone) {

        if (username == null || username.trim().isEmpty()) {
            System.out.println(" Username không hợp lệ");
            return;
        }

        if (balance < 0) {
            System.out.println(" Số dư không hợp lệ");
            return;
        }

        if (!zone.equalsIgnoreCase("VIP") && !zone.equalsIgnoreCase("NORMAL")) {
            System.out.println(" Zone không hợp lệ");
            return;
        }

        if (balance < 5000) {
            if (zone.equalsIgnoreCase("VIP")) {
                notificationServices.get("vipNotification")
                        .notifyUser(username, balance);
            } else {
                notificationServices.get("normalNotification")
                        .notifyUser(username, balance);
            }
        }
    }
}