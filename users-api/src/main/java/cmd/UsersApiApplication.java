package cmd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@RestController
@SpringBootApplication
public class UsersApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsersApiApplication.class, args);
    }

    @RequestMapping("/")
    public String index() {
        return "Hello world from user API.";
    }

}
