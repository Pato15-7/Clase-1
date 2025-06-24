/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.dto.VenDTO;
import com.example.demo.dto.VentaDTO;
import com.example.demo.model.Producto;
import com.example.demo.model.Venta;
import com.example.demo.repository.IVentaRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Patricio
 */
@Service
public class VentaService implements IVentaService{

    @Autowired
    IVentaRepository ventaRepo;
    
    @Autowired
    IProductoService prodService;
    
    @Override
    public void altaVenta(Venta venta) {
        prodService.DescontarStock(venta.getListaProductos());
        ventaRepo.save(venta);
    }

    @Override
    public void bajaVenta(Long id) {
        ventaRepo.deleteById(id);
    }

    @Override
    public void editarVenta(Venta venta) {
        Venta ven=ventaRepo.findById(venta.getCodigo_venta()).orElse(null);
        ven.setFecha_venta(venta.getFecha_venta());
        ven.setTotal(venta.getTotal());
        ven.setListaProductos(venta.getListaProductos());
        ven.setCliente(venta.getCliente());
        ventaRepo.save(venta);
    }

    @Override
    public List<Venta> getAll() {
        return ventaRepo.findAll();
    }

    @Override
    public Venta getVenta(Long id) {
        return ventaRepo.findById(id).orElse(null);
    }

    @Override
    public List<Producto> getVentaProductos(Long codigo_venta) {
        Venta ven=getVenta(codigo_venta);
        return ven.getListaProductos();
    }

    @Override
    public VenDTO getVentaFecha(LocalDate fecha_venta) {
        
        VenDTO venDTO= new VenDTO();
        
        List<Venta> lista= getAll();
        double total=0;
        int cantidadVentas=0;
        
        for(Venta ven : lista){
            if(ven.getFecha_venta().equals(fecha_venta)){
                venDTO.setTotal(total+=ven.getTotal());
                cantidadVentas+=1;
            }
        }
        venDTO.setCantidadVentas(cantidadVentas);
        return venDTO;
    }

    @Override
    public VentaDTO getVentaDTO() {
        VentaDTO ventaDTO=new VentaDTO();
        List<Venta> lista= getAll();
        Venta ventaMasCara=new Venta();
        ventaMasCara.setTotal((double)0);
        int cantidadProductos=0;
        for(Venta ven : lista){
            if(ven.getTotal()>ventaMasCara.getTotal()){
                ventaMasCara=ven;
                
            }
        }
        cantidadProductos=ventaMasCara.getListaProductos().size();
        ventaDTO.setCodigo_venta(ventaMasCara.getCodigo_venta());
        ventaDTO.setTotal(ventaMasCara.getTotal());
        ventaDTO.setNombre_cliente(ventaMasCara.getCliente().getNombre());
        ventaDTO.setApellido_cliente(ventaMasCara.getCliente().getApellido());
        ventaDTO.setCantidadProductos(cantidadProductos);
        
        return ventaDTO;
    }
}
