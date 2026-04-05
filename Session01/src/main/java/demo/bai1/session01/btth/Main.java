package demo.bai1.session01.btth;

import demo.bai1.session01.btth.config.AppConfig;
import demo.bai1.session01.btth.service.PlaySessionService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        PlaySessionService service =
                context.getBean(PlaySessionService.class);

        service.checkBalance("Hoan", 4000, "VIP");
        service.checkBalance("Nam", 3000, "NORMAL");

        service.checkBalance("", 3000, "VIP");
        service.checkBalance("An", -100, "VIP");
    }
}