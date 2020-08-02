package cl.computin.springboot.microservicio.app.item.service;

import cl.computin.springboot.microservicio.app.item.models.Item;
import cl.computin.springboot.servicio.common.models.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private RestTemplate clienteRest;

    @Override
    public List<Item> findAll() {
        //1° obtener listado de productos
        List<Producto> productos = Arrays.asList(clienteRest.getForObject("http://localhost:8001/listar",Producto[].class));
        //2° transformar esta lista de productos en una lista de items
        return  productos.stream().map(p -> new Item(p,1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        Map<String, String> pathVariables = new  LinkedHashMap<String, String>();
        pathVariables.put("id", id.toString());
        Producto producto = clienteRest.getForObject("http://localhost:8001/ver/{id}", Producto.class, pathVariables);
        return new Item(producto,cantidad);
    }

    @Override
    public Producto save(Producto producto) {
        HttpEntity<Producto> body= new HttpEntity<Producto>(producto);
        ResponseEntity<Producto> responseBody = clienteRest.exchange("http://localhost:8001/crear", HttpMethod.POST, body, Producto.class);
        return responseBody.getBody();
    }

    @Override
    public Producto update(Producto producto, Long id) {
        Map<String, String> pathVariable= new LinkedHashMap<>();
        pathVariable.put("id", id.toString());
        HttpEntity<Producto> body= new HttpEntity<Producto>(producto);
        ResponseEntity<Producto> responseBody = clienteRest.exchange("http://localhost:8001/modificar/{id}", HttpMethod.PUT, body, Producto.class,pathVariable);
        return responseBody.getBody();
    }

    @Override
    public void delete(Long id) {
        Map<String, String> pathVariable= new LinkedHashMap<>();
        pathVariable.put("id", id.toString());
        clienteRest.delete("http://localhost:8001/eliminar/{id}", pathVariable);
    }
}
