/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufps.arquitectura.valueObject;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author jjcarrillo
 */
@Entity
@Table(name="empresa_producto_pedido")
public class EmpresaProductoPedido implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private int cantidad;

    @ManyToOne(fetch=FetchType.LAZY)
    private Pedido pedido;

    @ManyToOne(fetch=FetchType.LAZY)
    private EmpresaProducto empresaProducto;

    public EmpresaProductoPedido() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long idProductoPedido) {
        this.id = idProductoPedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public EmpresaProducto getEmpresaProducto() {
        return empresaProducto;
    }

    public void setEmpresaProducto(EmpresaProducto empresaProducto) {
        this.empresaProducto = empresaProducto;
    }

    private static final long serialVersionUID = 1L;
}
