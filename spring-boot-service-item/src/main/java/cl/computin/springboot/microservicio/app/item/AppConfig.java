package cl.computin.springboot.microservicio.app.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean("clienteRest") //registramos un nuevo bean de restTemplate
    public RestTemplate registrarRestTemplate(){
        return new RestTemplate();
    }
}
