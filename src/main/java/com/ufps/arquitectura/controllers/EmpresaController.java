/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufps.arquitectura.controllers;

import com.ufps.arquitectura.service.IEmpresaProductoService;
import com.ufps.arquitectura.service.IEmpresaService;
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
public class EmpresaController {

    @Autowired
    private IEmpresaService empresaService;

    @Autowired
    private IEmpresaProductoService empresaProductoService;

    @GetMapping("/empresa/formulario")
    public String registrar(Model model) {
        model.addAttribute("mensaje", "Registrar la Empresa");
        model.addAttribute("empresa", new Empresa());
        return "formularioEmpresa";
    }

    @GetMapping("/empresa/formulario/{id}")
    public String modificar(@PathVariable(value="id") Long id, Model model) {
        model.addAttribute("mensaje", "Modificar la Empresa");
        Empresa empresa = null;
        if (id > 0) {
            empresa = empresaService.findById(id);
        } else {
            return "redirect:/empresa/listar";
        }
        model.addAttribute("empresa", empresa);
        return "formularioEmpresa";
    }

    @GetMapping("/empresa/listar")
    public String listar(Model model) {
        model.addAttribute("empresas", empresaService.findAll());
        return "listaEmpresa";
    }

    @GetMapping("/empresa/producto/{id}")
    public String verProductos(@PathVariable(value="id") Long id, Model model) {
        Empresa empresa = null;
        if (id > 0) {
            empresa = empresaService.findById(id);
        } else {
            return "redirect:/empresa/listar";
        }
        model.addAttribute("empresaProductos", empresa.getEmpresaProductos());
        return "listaProductoEmpresa";
    }

    @PostMapping("/empresa/registrar")
    public String registrar(Empresa empresa) {
        empresaService.save(empresa);
        return "redirect:/empresa/listar";
    }
}
