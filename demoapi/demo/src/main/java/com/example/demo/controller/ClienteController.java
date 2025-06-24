/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.model.Cliente;
import com.example.demo.service.IClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Patricio
 */
@RestController
public class ClienteController {
    
    @Autowired
    IClienteService cliService;
    
    @PostMapping("clientes/crear")
    public String altaCliente(@RequestBody Cliente cliente){
        cliService.altaCliente(cliente);
        return "El cliente se agrego correctamente!";
    }
    
    @PutMapping("clientes/editar/{id_cliente}")
    public String editarCliente(@PathVariable Long id_cliente,
                                @RequestBody Cliente cliente){
        cliente.setId_cliente(id_cliente);
        cliService.editarCliente(cliente);
        return "El cliente se edito correctamente!";
    }
    
    @GetMapping("clientes")
    public List<Cliente> getAll(){
        return cliService.getAll();
    }
    
    @DeleteMapping("clientes/eliminar/{id_cliente}")
    public String eliminarCliente(@PathVariable Long id_cliente){
        cliService.bajaCliente(id_cliente);
        return "El cliente se elimino correctamente";
    }
    
    @GetMapping("clientes/{id_cliente}")
    public Cliente getCliente(@PathVariable Long id_cliente){
        return cliService.getCliente(id_cliente);
    }
}
