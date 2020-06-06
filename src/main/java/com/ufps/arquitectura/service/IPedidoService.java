/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufps.arquitectura.service;

import com.ufps.arquitectura.valueObject.Pedido;
import java.util.List;

/**
 *
 * @author jjcarrillo
 */
public interface IPedidoService {

    public List<Pedido> findAll();

    public void save(Pedido pedido);

    public Pedido findById(Long id);

    public void delete(Long id);
}
