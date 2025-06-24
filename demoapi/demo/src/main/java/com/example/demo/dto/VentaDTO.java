/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dto;

import com.example.demo.model.Cliente;
import com.example.demo.model.Producto;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Patricio
 */
@Getter @Setter
public class VentaDTO {
    private Long codigo_venta;
    private Double total;
    private int cantidadProductos;
    private String nombre_cliente;
    private String apellido_cliente;

    public VentaDTO() {
    }

    public VentaDTO(Long codigo_venta, Double total, int cantidadProductos, String nombre_cliente, String apellido_cliente) {
        this.codigo_venta = codigo_venta;
        this.total = total;
        this.cantidadProductos = cantidadProductos;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
    }
    
    
}
