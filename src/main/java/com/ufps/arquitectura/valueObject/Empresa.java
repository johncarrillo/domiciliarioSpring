/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufps.arquitectura.valueObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author jjcarrillo
 */
@Entity
@Table(name="empresa")
public class Empresa implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String nit;

    private String nombre;

    private String direccion;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="empresa")
    private List<Pedido> pedidos;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="empresa")
    private List<EmpresaProducto> empresaProductos;

    public Empresa() {
        pedidos = new ArrayList<Pedido>();
        empresaProductos = new ArrayList<EmpresaProducto>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long idEmpresa) {
        this.id = idEmpresa;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public List<EmpresaProducto> getEmpresaProductos() {
        return empresaProductos;
    }

    public void setEmpresaProductos(List<EmpresaProducto> empresaProductos) {
        this.empresaProductos = empresaProductos;
    }

    public void addEmpresaProducto (EmpresaProducto empresaProducto) {
        empresaProductos.add(empresaProducto);
    }

    public void addPedido (Pedido pedido) {
        pedidos.add(pedido);
    }

    private static final long serialVersionUID = 1L;
}
