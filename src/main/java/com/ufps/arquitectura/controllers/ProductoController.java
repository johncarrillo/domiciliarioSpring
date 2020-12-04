/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufps.arquitectura.controllers;

import java.util.List;

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
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jjcarrillo
 */
@Controller
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @Autowired
    private IEmpresaService empresaService;

    @Autowired
    private IEmpresaProductoService empresaProductoService;

    @GetMapping(value = "/registrar")
    public String viewRegistrar(Model model) {
        model.addAttribute("titulo", "Registrar Producto");
        return "registrarproducto";
    }

    @GetMapping("/listar")
    public List<Producto> listar() {
        return productoService.findAll();
    }

    @GetMapping("/{id}")
    public Producto consultar(@PathVariable(value = "id") Long id) {
        return productoService.findById(id);
    }



    @PostMapping("/registrar")
    public ModelAndView  registrar(Producto producto) {
        productoService.save(producto);
        return new ModelAndView("redirect:/empresa/");
    }

    @PutMapping("/editar")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto modificar(@RequestBody Producto producto) {
        productoService.save(producto);
        return producto;
    }


    @PostMapping("/empresa/registrar")
    @ResponseStatus(HttpStatus.CREATED)
    public EmpresaProducto registrarProductoEmpresa(EmpresaProducto empresaProducto) {
        empresaProductoService.save(empresaProducto);
        return empresaProducto;
    }
}
