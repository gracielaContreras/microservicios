package cl.computin.springboot.microservicio.app.item.service;

import cl.computin.springboot.servicio.common.models.entity.Producto;
import cl.computin.springboot.microservicio.app.item.models.Item;

import java.util.List;

public interface ItemService {

   public List<Item>findAll();

   public Item findById(Long id, Integer cantidad);

   public Producto save(Producto producto);

   public Producto update(Producto producto, Long id);

   public void delete(Long id);
}
