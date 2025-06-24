/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.model.Cliente;
import com.example.demo.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Patricio
 */
@Service
public class ClienteService implements IClienteService{

    @Autowired
    IClienteRepository clienteRepo;
    
    @Override
    public void altaCliente(Cliente cliente) {
        clienteRepo.save(cliente);
    }

    @Override
    public void bajaCliente(Long id) {
        clienteRepo.deleteById(id);
    }

    @Override
    public void editarCliente(Cliente cliente) {
        Cliente cli=clienteRepo.findById(cliente.getId_cliente()).orElse(null);
        cli.setNombre(cliente.getNombre());
        cli.setApellido(cliente.getApellido());
        cli.setDni(cliente.getDni());
        clienteRepo.save(cli);
    }

    @Override
    public List<Cliente> getAll() {
        return clienteRepo.getAllClientes();
    }

    @Override
    public Cliente getCliente(Long id) {
        return clienteRepo.findById(id).orElse(null);
    }
    
}
