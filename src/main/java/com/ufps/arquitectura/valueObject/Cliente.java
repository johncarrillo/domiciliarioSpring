/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufps.arquitectura.valueObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
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
@Table(name="cliente")
public class Cliente implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="numero_documento")
    private String numeroDocumento;

    private String nombre;

    private String direccion;

    private String celular;

    private String token_usuario;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="cliente")
    private List<Pedido> pedidos;

    public Cliente() {
        pedidos = new ArrayList<Pedido>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long idCliente) {
        this.id = idCliente;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void addPedido (Pedido pedido) {
        pedidos.add(pedido);
    }

    private static final long serialVersionUID = 1L;

    public String getToken_usuario() {
        return token_usuario;
    }

    public void setToken_usuario(String token_usuario) {
        this.token_usuario = token_usuario;
    }
}
