/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufps.arquitectura.valueObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author jjcarrillo
 */
@Entity
@Table(name="pedido")
public class Pedido implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    private Cliente cliente;

    @ManyToOne(fetch=FetchType.LAZY)
    private Domiciliario domiciliario;

    @ManyToOne(fetch=FetchType.LAZY)
    private Empresa empresa;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEntrega;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="pedido")
    private List<EmpresaProductoPedido> empresaProductoPedidos;

    public Pedido() {
        empresaProductoPedidos = new ArrayList<EmpresaProductoPedido>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long idPedido) {
        this.id = idPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Domiciliario getDomiciliario() {
        return domiciliario;
    }

    public void setDomiciliario(Domiciliario domiciliario) {
        this.domiciliario = domiciliario;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public List<EmpresaProductoPedido> getEmpresaProductoPedidos() {
        return empresaProductoPedidos;
    }

    public void setEmpresaProductoPedidos(List<EmpresaProductoPedido> empresaProductoPedidos) {
        this.empresaProductoPedidos = empresaProductoPedidos;
    }

    public void addEmpresaProductoPedidos (EmpresaProductoPedido empresaProductoPedido) {
        empresaProductoPedidos.add(empresaProductoPedido);
    }

    @PrePersist
    public void prePersist() {
        fechaCreacion = new Date();
    }

    private static final long serialVersionUID = 1L;
}
