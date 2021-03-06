/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufps.arquitectura.controllers;

import com.ufps.arquitectura.service.IClienteService;
import com.ufps.arquitectura.service.IDomiciliarioService;
import com.ufps.arquitectura.service.IEmpresaProductoPedidoService;
import com.ufps.arquitectura.service.IEmpresaProductoService;
import com.ufps.arquitectura.service.IEmpresaService;
import com.ufps.arquitectura.service.IPedidoService;
import com.ufps.arquitectura.valueObject.EmpresaProducto;
import com.ufps.arquitectura.valueObject.EmpresaProductoPedido;
import com.ufps.arquitectura.valueObject.Pedido;
import com.ufps.arquitectura.valueObject.Producto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author jjcarrillo
 */
@Controller
public class PedidoController {

    @Autowired
    private IEmpresaService empresaService;

    @Autowired
    private IClienteService clienteService;

    @Autowired
    private IPedidoService pedidoService;

    @Autowired
    private IEmpresaProductoService empresaProductoService;

    @Autowired
    private IEmpresaProductoPedidoService empresaProductoPedidoService;

    @Autowired
    private IDomiciliarioService domiciliarioService;

    @GetMapping("/pedido/formulario")
    public String registrar(Model model) {
        model.addAttribute("clientes", clienteService.findAll());
        model.addAttribute("empresas", empresaService.findAll());
        model.addAttribute("pedido", new Pedido());
        return "formularioPedido";
    }

    
    @PostMapping("/pedido/crear")
    public String registrar(Pedido pedido) {
        pedidoService.save(pedido);
        return "redirect:/pedido/agregarProducto/" + pedido.getEmpresa().getId() + "/" + pedido.getId();
    }

    @GetMapping("/pedido/agregarProducto/{idEmpresa}/{idPedido}")
    public String agregarProducto(@PathVariable(value="idEmpresa") Long idEmpresa,
    		@PathVariable(value="idPedido") Long idPedido, Model model) {
    	Pedido pedido = pedidoService.findById(idPedido);
        model.addAttribute("pedido", pedido);
        List<EmpresaProducto> listaProductos = new ArrayList();
        for (EmpresaProducto empresaProducto : empresaProductoService.findAll()) {
        	if (empresaProducto.getEmpresa().getId().equals(idEmpresa)) {
        		listaProductos.add(empresaProducto);
        	}
        }
        EmpresaProductoPedido empresaProductoPedido = new EmpresaProductoPedido();
        empresaProductoPedido.setPedido(pedido);
        model.addAttribute("empresaProductoPedido", empresaProductoPedido);
        model.addAttribute("empresaProductos", listaProductos);
        return "formularioAgregarProducto";
    }

    @PostMapping("/pedido/agregar")
    public String registrar(EmpresaProductoPedido empresaProductoPedido) {
    	empresaProductoPedidoService.save(empresaProductoPedido);
        return "redirect:/pedido/listar";
    }

    @GetMapping("/pedido/listar")
    public String listar(Model model) {
        model.addAttribute("pedidos", pedidoService.findAll());
        return "listaPedidos";
    }

    @GetMapping("/pedido/confirmarEntrega/{id}")
    public String confirmarEntrega(@PathVariable(value="id") Long id, Model model) {
        model.addAttribute("pedido", pedidoService.findById(id));
        model.addAttribute("domiciliarios", domiciliarioService.findAll());
        return "confirmarEntrega";
    }

    @PostMapping("/pedido/confirmarEntrega")
    public String confirmarEntrega(Pedido pedido) {
    	pedido.setFechaEntrega(new Date());; 
    	pedidoService.save(pedido);
        return "redirect:/pedido/listar";
    }
}
