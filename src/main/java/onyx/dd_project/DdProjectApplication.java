package onyx.dd_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class DdProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(DdProjectApplication.class, args);
    }
}
