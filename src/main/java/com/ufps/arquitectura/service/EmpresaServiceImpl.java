/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufps.arquitectura.service;

import com.ufps.arquitectura.dao.IEmpresaDao;
import com.ufps.arquitectura.valueObject.Empresa;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author jjcarrillo
 */
@Service
public class EmpresaServiceImpl implements IEmpresaService{
    @Autowired
    private IEmpresaDao empresaDao;

    @Override
    @Transactional(readOnly=true)
    public List<Empresa> findAll() {
        return (List<Empresa>) empresaDao.findAll();
    }

    @Override
    @Transactional
    public void save(Empresa empresa) {
        empresaDao.save(empresa);
    }

    @Override
    @Transactional(readOnly=true)
    public Empresa findById(Long id) {
        return empresaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        empresaDao.deleteById(id);
    }

}
