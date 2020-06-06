/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufps.arquitectura.dao;

import com.ufps.arquitectura.valueObject.Cliente;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author jjcarrillo
 */
public interface IClienteDao extends CrudRepository<Cliente, Long> {
}
