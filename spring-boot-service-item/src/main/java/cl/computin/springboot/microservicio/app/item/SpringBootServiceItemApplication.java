package cl.computin.springboot.microservicio.app.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringBootServiceItemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootServiceItemApplication.class, args);
    }

}
