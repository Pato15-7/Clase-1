/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.model.Cliente;
import com.example.demo.model.Venta;
import java.util.List;

/**
 *
 * @author Patricio
 */
public interface IClienteService {
    public void altaCliente(Cliente cliente);
    public void bajaCliente(Long id);
    public void editarCliente(Cliente cliente);
    public List<Cliente> getAll();
    public Cliente getCliente(Long id);
}
