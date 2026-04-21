package sesison12.bai3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class HospitalInfoConfig implements CommandLineRunner {
    @Value("${hospital.name}")
    private String hospitalName;

    @Value("${hospital.hotline}")
    private String hotline;

    @Value("${hospital.db-ip}")
    private String dbIp;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Tên đơn vị: " + hospitalName);
        System.out.println("Hotline hỗ trợ: " + hotline);
        System.out.println("Kết nối Database tại IP: " + dbIp);
    }
}
