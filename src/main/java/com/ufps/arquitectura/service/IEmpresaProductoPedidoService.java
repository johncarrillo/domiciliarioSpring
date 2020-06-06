/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufps.arquitectura.service;

import com.ufps.arquitectura.valueObject.EmpresaProductoPedido;
import java.util.List;

/**
 *
 * @author jjcarrillo
 */
public interface IEmpresaProductoPedidoService {

    public List<EmpresaProductoPedido> findAll();

    public void save(EmpresaProductoPedido productoPedido);

    public EmpresaProductoPedido findById(Long id);

    public void delete(Long id);
}
