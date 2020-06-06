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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author jjcarrillo
 */
@Entity
@Table(name="empresa_producto")
public class EmpresaProducto implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    private Producto producto;

    @ManyToOne(fetch=FetchType.LAZY)
    private Empresa empresa;

    private Double precio;

//    @OneToMany(fetch=FetchType.LAZY, mappedBy="empresa_producto")
//    private List<EmpresaProductoPedido> empresaProductoPedidos;

    public EmpresaProducto() {
//        empresaProductoPedidos = new ArrayList<EmpresaProductoPedido>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long idEmpresaProducto) {
        this.id = idEmpresaProducto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

//    public List<EmpresaProductoPedido> getEmpresaProductoPedidos() {
//        return empresaProductoPedidos;
//    }
//
//    public void setEmpresaProductoPedidos(List<EmpresaProductoPedido> empresaProductoPedidos) {
//        this.empresaProductoPedidos = empresaProductoPedidos;
//    }
//
//    public void addEmpresaProductoPedidos(EmpresaProductoPedido empresaProductoPedido) {
//        this.empresaProductoPedidos.add(empresaProductoPedido);
//    }

    private static final long serialVersionUID = 1L;
}
