package cl.computin.springboot.microservicio.app.productos.controllers;

import cl.computin.springboot.servicio.common.models.entity.Producto;
import cl.computin.springboot.microservicio.app.productos.models.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private IProductoService iProductoService;
    @GetMapping("/listar")
    public List<Producto> listar(){return iProductoService.findAll();
    }
    @GetMapping("/ver/{id}")
    public Producto detalle(@PathVariable Long id){
        return iProductoService.findById(id);
    }

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto agregarProducto(@RequestBody Producto producto){
        return iProductoService.save(producto);
    }


    @PutMapping("/modificar/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto modificarProducto(@RequestBody Producto producto,@PathVariable Long id ){
        Producto productoModificado = iProductoService.findById(id);
        productoModificado.setNombre(producto.getNombre());
        productoModificado.setPrecio(producto.getPrecio());
        return iProductoService.save(productoModificado);
    }

    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarProducto(@PathVariable Long id){
        iProductoService.deleteById(id);
    }
}
