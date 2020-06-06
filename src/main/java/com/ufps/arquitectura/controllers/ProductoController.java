/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufps.arquitectura.controllers;

import com.ufps.arquitectura.service.IEmpresaProductoService;
import com.ufps.arquitectura.service.IEmpresaService;
import com.ufps.arquitectura.service.IProductoService;
import com.ufps.arquitectura.valueObject.Domiciliario;
import com.ufps.arquitectura.valueObject.Empresa;
import com.ufps.arquitectura.valueObject.EmpresaProducto;
import com.ufps.arquitectura.valueObject.Producto;
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
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @Autowired
    private IEmpresaService empresaService;

    @Autowired
    private IEmpresaProductoService empresaProductoService;

    @GetMapping("/producto/formulario")
    public String registrar(Model model) {
        model.addAttribute("mensaje", "Registrar Producto");
        model.addAttribute("producto", new Producto());
        return "formularioProducto";
    }

    @GetMapping("/producto/listar")
    public String listar(Model model) {
        model.addAttribute("productos", productoService.findAll());
        return "listaProducto";
    }

    @GetMapping("/producto/formulario/{id}")
    public String modificar(@PathVariable(value="id") Long id, Model model) {
        model.addAttribute("mensaje", "Modificar la Producto");
        Producto producto = null;
        if (id > 0) {
            producto = productoService.findById(id);
        } else {
            return "redirect:/producto/listar";
        }
        model.addAttribute("producto", producto);
        return "formularioProducto";
    }

    @GetMapping("/producto/empresa/formulario")
    public String registrarProductoEmpresa(Model model) {
        model.addAttribute("productos", productoService.findAll());
        model.addAttribute("empresas", empresaService.findAll());
        model.addAttribute("empresaProducto", new EmpresaProducto());
        return "formularioEmpresaProducto";
    }

    @PostMapping("/producto/registrar")
    public String registrar(Producto producto) {
        productoService.save(producto);
        return "redirect:/producto/listar";
    }

    @PostMapping("/producto/empresa/registrar")
    public String registrarProductoEmpresa(EmpresaProducto empresaProducto) {
        empresaProductoService.save(empresaProducto);
        return "redirect:/empresa/listar";
    }
}
