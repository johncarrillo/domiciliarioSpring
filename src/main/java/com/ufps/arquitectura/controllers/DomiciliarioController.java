/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufps.arquitectura.controllers;

import java.util.List;

import com.ufps.arquitectura.service.IDomiciliarioService;
import com.ufps.arquitectura.valueObject.Cliente;
import com.ufps.arquitectura.valueObject.Domiciliario;
import com.ufps.arquitectura.valueObject.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jjcarrillo
 */
@RestController
@RequestMapping("/domiciliario")
public class DomiciliarioController {

    @Autowired
    private IDomiciliarioService domiciliarioService;

    @GetMapping("/listar")
    public List<Domiciliario> listar(Model model) {
        return domiciliarioService.findAll();
    }

    @GetMapping("/{id}")
    public Domiciliario consultar(@PathVariable(value = "id") Long id) {
        return domiciliarioService.findById(id);
    }

    @PostMapping("/registrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Domiciliario registrar(@RequestBody Domiciliario domiciliario) {
        domiciliarioService.save(domiciliario);
        return domiciliario;
    }

    @PutMapping("/editar")
    @ResponseStatus(HttpStatus.CREATED)
    public Domiciliario modificar(@RequestBody Domiciliario domiciliario) {
        domiciliarioService.save(domiciliario);
        return domiciliario;
    }

}
