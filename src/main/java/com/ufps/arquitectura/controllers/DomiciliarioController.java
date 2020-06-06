/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufps.arquitectura.controllers;

import com.ufps.arquitectura.service.IDomiciliarioService;
import com.ufps.arquitectura.valueObject.Cliente;
import com.ufps.arquitectura.valueObject.Domiciliario;
import com.ufps.arquitectura.valueObject.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author jjcarrillo
 */
@Controller
public class DomiciliarioController {

    @Autowired
    private IDomiciliarioService domiciliarioService;

    @GetMapping("/domiciliario/formulario")
    public String registrar(Model model) {
        model.addAttribute("mensaje", "Registrar Domiciliario");
        model.addAttribute("domiciliario", new Domiciliario());
        return "formularioDomiciliario";
    }

    @GetMapping("/domiciliario/listar")
    public String listar(Model model) {
        model.addAttribute("domiciliarios", domiciliarioService.findAll());
        return "listaDomiciliario";
    }

    @GetMapping("/domiciliario/formulario/{id}")
    public String modificar(@PathVariable(value="id") Long id, Model model) {
        model.addAttribute("mensaje", "Modificar la Domiciliario");
        Domiciliario domiciliario = null;
        if (id > 0) {
            domiciliario = domiciliarioService.findById(id);
        } else {
            return "redirect:/domiciliario/listar";
        }
        model.addAttribute("domiciliario", domiciliario);
        return "formularioDomiciliario";
    }

    @PostMapping("/domiciliario/registrar")
    public String registrar(Domiciliario domiciliario) {
        System.out.println("domiciliario.id " + domiciliario.getId());
        domiciliarioService.save(domiciliario);
        return "redirect:/domiciliario/listar";
    }
}
