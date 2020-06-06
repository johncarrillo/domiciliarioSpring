/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufps.arquitectura.service;

import com.ufps.arquitectura.valueObject.Empresa;
import java.util.List;

/**
 *
 * @author jjcarrillo
 */
public interface IEmpresaService {

    public List<Empresa> findAll();

    public void save(Empresa empresa);

    public Empresa findById(Long id);

    public void delete(Long id);
}
