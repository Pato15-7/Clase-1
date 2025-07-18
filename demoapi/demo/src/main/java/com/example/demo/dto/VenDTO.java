/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Patricio
 */
@Getter @Setter
public class VenDTO {
    private double total;
    private int cantidadVentas;

    public VenDTO() {
    }

    public VenDTO(double total, int cantidadVentas) {
        this.total = total;
        this.cantidadVentas = cantidadVentas;
    }
}
