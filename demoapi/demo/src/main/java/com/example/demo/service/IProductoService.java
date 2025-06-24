/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.model.Producto;
import com.example.demo.model.Venta;
import java.util.List;

/**
 *
 * @author Patricio
 */
public interface IProductoService {
    public void altaProducto(Producto producto);
    public void bajaProducto(Long id);
    public void editarProducto(Producto producto);
    public List<Producto> getAll();
    public Producto getProducto(Long id);
    public void DescontarStock(List<Producto> prod);
    public List<Producto> getProductoFaltaStock();
}
