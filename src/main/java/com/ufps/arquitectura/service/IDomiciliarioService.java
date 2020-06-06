/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufps.arquitectura.service;

import com.ufps.arquitectura.valueObject.Domiciliario;
import java.util.List;

/**
 *
 * @author jjcarrillo
 */
public interface IDomiciliarioService {

    public List<Domiciliario> findAll();

    public void save(Domiciliario domiciliario);

    public Domiciliario findById(Long id);

    public void delete(Long id);
}
