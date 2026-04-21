package ra;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Bai1Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Bai1Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hospital Web Service is ready on Embedded Tomcat!");
    }
}
