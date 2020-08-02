package cl.computin.springboot.microservicio.app.productos.models.service;

import cl.computin.springboot.servicio.common.models.entity.Producto;

import java.util.List;

public interface IProductoService {

    public List<Producto> findAll();
    public Producto findById(Long id);
    public Producto save(Producto producto);
    public void deleteById(Long id);
}
