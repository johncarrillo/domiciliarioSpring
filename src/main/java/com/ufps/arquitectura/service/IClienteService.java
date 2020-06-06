/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufps.arquitectura.service;

import com.ufps.arquitectura.valueObject.Cliente;
import java.util.List;

/**
 *
 * @author jjcarrillo
 */
public interface IClienteService {

    public List<Cliente> findAll();

    public void save(Cliente cliente);

    public Cliente findById(Long id);

    public void delete(Long id);
}
