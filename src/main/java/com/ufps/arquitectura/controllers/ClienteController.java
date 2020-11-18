/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufps.arquitectura.controllers;

import java.util.List;

import com.ufps.arquitectura.service.IClienteService;
import com.ufps.arquitectura.valueObject.Cliente;
import com.ufps.arquitectura.valueObject.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jjcarrillo
 */
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping("/cliente/formulario")
    public String registrar(Model model) {
        model.addAttribute("mensaje", "Registrar la Cliente");
        model.addAttribute("cliente", new Cliente());
        return "formularioCliente";
    }

    @GetMapping("/listar")
    public List<Cliente> listar(Model model) {
       // model.addAttribute("clientes", clienteService.findAll());
        return clienteService.findAll();
    }

    @GetMapping("/cliente/formulario/{id}")
    public String modificar(@PathVariable(value="id") Long id, Model model) {
        model.addAttribute("mensaje", "Modificar la Cliente");
        Cliente cliente = null;
        if (id > 0) {
            cliente = clienteService.findById(id);
        } else {
            return "redirect:/cliente/listar";
        }
        model.addAttribute("cliente", cliente);
        return "formularioCliente";
    }

    @PostMapping("/cliente/registrar")
    public String registrar(Cliente cliente) {
        System.out.println("cliente.id " + cliente.getId());
        clienteService.save(cliente);
        return "redirect:/cliente/listar";
    }
}
