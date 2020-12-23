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
import com.ufps.arquitectura.valueObject.Empresa;
import com.ufps.arquitectura.valueObject.EmpresaProducto;
import com.ufps.arquitectura.valueObject.Producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author jjcarrillo
 */
@Controller
@RequestMapping("/empresaAdmin")
public class EmpresaAdminController {

    @Autowired
    private IEmpresaService empresaService;

    @Autowired
    private IProductoService productoService;

    @Autowired
    private IEmpresaProductoService empresaProductoService;

    @GetMapping(value = { "/", "/index" })
    public String index(Model model) {
        model.addAttribute("titulo", "Bienvenido");
        return "index";
    }

    @GetMapping(value = "/registrar")
    public String viewRegistrar(Model model) {
        model.addAttribute("titulo", "Registrar Empresa");

        return "registrarempresa";
    }

    @RequestMapping(value = "/registrar", method = RequestMethod.POST)
    public String registrar(Empresa empresa, RedirectAttributes flash) {
        if (empresa != null) {
            empresaService.save(empresa);
            flash.addFlashAttribute("error", "HA OCURRIDO UN ERROR");
            return "redirect:index";
        } else {
            flash.addFlashAttribute("error", "HA OCURRIDO UN ERROR");
            return "registrarempresa";
        }

    }

    @GetMapping(value = "/asignarproducto")
    public String viewAsignarProducto(Model model) {
        model.addAttribute("titulo", "Asigne un producto a la empresa");
        List<Empresa> empresas = empresaService.findAll();
        List<Producto> productos = productoService.findAll();
        model.addAttribute("empresas", empresas);
        model.addAttribute("productos", productos);
        return "asignarproducto";
    }

    @RequestMapping(value = "/asignarproducto", method = RequestMethod.POST)
    public String asignarProducto(EmpresaProducto empresaproducto, RedirectAttributes flash) {
        Empresa empresa = empresaproducto.getEmpresa();
        System.out.println(empresa.getNombre());
        empresaProductoService.save(empresaproducto);
        return "redirect:index";

    }

    /*
     * @GetMapping("/{id}") public Empresa consultar(@PathVariable(value = "id")
     * Long id) { return empresaService.findById(id); }
     * 
     * @PostMapping("/registrar")
     * 
     * @ResponseStatus(HttpStatus.CREATED) public Empresa registrar(@RequestBody
     * Empresa empresa) { empresaService.save(empresa); return empresa; }
     * 
     * @PutMapping("/editar")
     * 
     * @ResponseStatus(HttpStatus.CREATED) public Empresa modificar(@RequestBody
     * Empresa empresa) { empresaService.save(empresa); return empresa; }
     * 
     * @GetMapping("/producto/{id}") public List<EmpresaProducto>
     * verProductos(@PathVariable(value = "id") Long id) { Empresa empresa = null;
     * empresa = empresaService.findById(id); return empresa.getEmpresaProductos();
     * 
     * }
     */

}
