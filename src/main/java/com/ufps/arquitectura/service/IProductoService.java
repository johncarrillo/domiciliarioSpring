/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufps.arquitectura.service;

import com.ufps.arquitectura.valueObject.Producto;
import java.util.List;

/**
 *
 * @author jjcarrillo
 */
public interface IProductoService {

    public List<Producto> findAll();

    public void save(Producto producto);

    public Producto findById(Long id);

    public void delete(Long id);
}
