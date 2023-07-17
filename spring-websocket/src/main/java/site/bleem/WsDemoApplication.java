package site.bleem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class WsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WsDemoApplication.class, args);
    }
}
