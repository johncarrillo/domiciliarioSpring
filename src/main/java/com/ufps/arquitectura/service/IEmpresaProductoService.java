/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufps.arquitectura.service;

import com.ufps.arquitectura.valueObject.EmpresaProducto;
import java.util.List;

/**
 *
 * @author jjcarrillo
 */
public interface IEmpresaProductoService {

    public List<EmpresaProducto> findAll();

    public void save(EmpresaProducto empresaProducto);

    public EmpresaProducto findById(Long id);

    public void delete(Long id);
}
