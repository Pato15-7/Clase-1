/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.model.Cliente;
import com.example.demo.model.Producto;
import com.example.demo.repository.IProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Patricio
 */
@Service
public class ProductoService implements IProductoService{

    @Autowired
    IProductoRepository prodRepo;
    
    @Override
    public void altaProducto(Producto producto) {
        prodRepo.save(producto);
    }

    @Override
    public void bajaProducto(Long id) {
        prodRepo.deleteById(id);
    }

    @Override
    public void editarProducto(Producto producto) {
        Producto prod=prodRepo.findById(producto.getCodigo_producto()).orElse(null);
        prod.setNombre(producto.getNombre());
        prod.setMarca(producto.getMarca());
        prod.setCosto(producto.getCosto());
        prod.setCantidad_disponible(producto.getCantidad_disponible());
        prodRepo.save(prod);
    }
    
    public void DescontarStock(List<Producto> lista){
        
        for(Producto prod : lista){
            prod=getProducto(prod.getCodigo_producto());
            double cantidad=prod.getCantidad_disponible();
            prod.setCantidad_disponible(cantidad-1);
            prodRepo.save(prod);
        }
    }

    @Override
    public List<Producto> getAll() {
        return prodRepo.findAll();
    }

    @Override
    public Producto getProducto(Long id) {
        return prodRepo.findById(id).orElse(null);
    }

    @Override
    public List<Producto> getProductoFaltaStock() {
        List<Producto> lista= getAll();
        List<Producto> listaFaltaStock= new ArrayList<>();
        for(Producto prod : lista){
            if(prod.getCantidad_disponible()<5) listaFaltaStock.add(prod);
        }
        return listaFaltaStock;
    }
}
