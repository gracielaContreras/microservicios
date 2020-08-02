package cl.computin.springboot.microservicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"cl.computin.springboot.servicio.common.models.entity"})
public class MicroservicioApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicioApplication.class, args);
    }

}
