package demo.bai1.session01.btth.notification;

import org.springframework.stereotype.Component;

@Component("vipNotification")
public class PopupNotification implements NotificationService {
    public void notifyUser(String username, double balance) {
        System.out.println(" [POPUP] " + username + " sắp hết tiền: " + balance);
    }
}