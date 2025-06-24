/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.model.Producto;
import com.example.demo.model.Venta;
import com.example.demo.service.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Patricio
 */
@RestController
public class ProductoController {
    
    @Autowired
    IProductoService prodSer;
    
    @PostMapping("producto/crear")
    public String altaProducto(@RequestBody Producto producto){
        prodSer.altaProducto(producto);
        return "El producto se agrego correctamente!";
    }
    
    @PutMapping("productos/editar/{codigo_producto}")
    public String editarProducto(@PathVariable Long codigo_producto,
                                @RequestBody Producto producto){
        producto.setCodigo_producto(codigo_producto);
        prodSer.editarProducto(producto);
        return "El producto se edito correctamente!";
    }
    
    @GetMapping("productos")
    public List<Producto> getAll(){
        return prodSer.getAll();
    }
    
    @DeleteMapping("productos/eliminar/{codigo_producto}")
    public String eliminarProducto(@PathVariable Long codigo_producto){
        prodSer.bajaProducto(codigo_producto);
        return "El producto se elimino correctamente";
    }
    
    @GetMapping("productos/{codigo_producto}")
    public Producto getProducto(@PathVariable Long codigo_producto){
        return prodSer.getProducto(codigo_producto);
    }
    
    @GetMapping("productos/falta_stock")
    public List<Producto> getProductoFaltaStock(){
        return prodSer.getProductoFaltaStock();
    }
}
