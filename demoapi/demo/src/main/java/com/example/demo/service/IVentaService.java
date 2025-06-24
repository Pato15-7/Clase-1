/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.dto.VenDTO;
import com.example.demo.dto.VentaDTO;
import com.example.demo.model.Producto;
import com.example.demo.model.Venta;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Patricio
 */
public interface IVentaService {
    public void altaVenta(Venta venta);
    public void bajaVenta(Long id);
    public void editarVenta(Venta venta);
    public List<Venta> getAll();
    public Venta getVenta(Long id);
    public List<Producto> getVentaProductos(Long codigo_venta);
    public VenDTO getVentaFecha(LocalDate fecha_venta);
    public VentaDTO getVentaDTO();
}
