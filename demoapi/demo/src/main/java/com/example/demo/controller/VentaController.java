/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.dto.VenDTO;
import com.example.demo.dto.VentaDTO;
import com.example.demo.model.Producto;
import com.example.demo.model.Venta;
import com.example.demo.service.IVentaService;
import java.time.LocalDate;
import java.util.Date;
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
public class VentaController {
    @Autowired
    IVentaService ventaSer;
    
    @PostMapping("ventas/crear")
    public String altaVenta(@RequestBody Venta venta){
        ventaSer.altaVenta(venta);
        return "La venta se agrego correctamente!";
    }
    
    @PutMapping("ventas/editar/{codigo_venta}")
    public String editarVenta(@PathVariable Long codigo_venta,
                                @RequestBody Venta venta){
        venta.setCodigo_venta(codigo_venta);
        ventaSer.editarVenta(venta);
        return "La venta se edito correctamente!";
    }
    
    @GetMapping("ventas")
    public List<Venta> getAll(){
        return ventaSer.getAll();
    }
    
    @DeleteMapping("ventas/eliminar/{codigo_venta}")
    public String eliminarVenta(@PathVariable Long codigo_venta){
        ventaSer.bajaVenta(codigo_venta);
        return "La venta se elimino correctamente";
    }
    
    @GetMapping("ventas/{codigo_venta}")
    public Venta getVenta(@PathVariable Long codigo_venta){
        return ventaSer.getVenta(codigo_venta);
    }
    
    @GetMapping("ventas/productos/{codigo_venta}")
    public List<Producto> getVentaProductos(@PathVariable Long codigo_venta){
        return ventaSer.getVentaProductos(codigo_venta);
    }
    
    @GetMapping("ventas/fecha/{fecha_venta}")
    public VenDTO getVentaFecha(@PathVariable LocalDate fecha_venta){
        return ventaSer.getVentaFecha(fecha_venta);
    }
    
    @GetMapping("ventas/mayor_venta")
    public VentaDTO getVentaMayor(){
        return ventaSer.getVentaDTO();
    }
    
    
    
}
