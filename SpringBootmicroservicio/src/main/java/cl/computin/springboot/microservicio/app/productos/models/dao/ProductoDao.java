package cl.computin.springboot.microservicio.app.productos.models.dao;

import cl.computin.springboot.servicio.common.models.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoDao extends CrudRepository<Producto, Long> {

}
