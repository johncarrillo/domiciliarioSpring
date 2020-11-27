/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufps.arquitectura.valueObject;

import java.io.Serializable;
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
@Table(name="producto")
public class Producto implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String imagen;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="producto")
    private List<EmpresaProducto> empresaProductos;

    public Long getId() {
        return id;
    }

    public void setId(Long idProducto) {
        this.id = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    
    
    private static final long serialVersionUID = 1L;

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
