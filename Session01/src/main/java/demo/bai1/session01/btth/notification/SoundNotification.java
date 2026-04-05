package demo.bai1.session01.btth.notification;

import org.springframework.stereotype.Component;

@Component("normalNotification")
public class SoundNotification implements NotificationService {
    public void notifyUser(String username, double balance) {
        System.out.println(" [SOUND] " + username + " sắp hết tiền: " + balance);
    }
}
