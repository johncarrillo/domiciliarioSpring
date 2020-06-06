/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufps.arquitectura.service;

import com.ufps.arquitectura.dao.IEmpresaProductoDao;
import com.ufps.arquitectura.valueObject.EmpresaProducto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author jjcarrillo
 */
@Service
public class EmpresaProductoServiceImpl implements IEmpresaProductoService{
    @Autowired
    private IEmpresaProductoDao empresaProductoDao;

    @Override
    @Transactional(readOnly=true)
    public List<EmpresaProducto> findAll() {
        return (List<EmpresaProducto>) empresaProductoDao.findAll();
    }

    @Override
    @Transactional
    public void save(EmpresaProducto empresaProducto) {
        empresaProductoDao.save(empresaProducto);
    }

    @Override
    @Transactional(readOnly=true)
    public EmpresaProducto findById(Long id) {
        return empresaProductoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        empresaProductoDao.deleteById(id);
    }

}
