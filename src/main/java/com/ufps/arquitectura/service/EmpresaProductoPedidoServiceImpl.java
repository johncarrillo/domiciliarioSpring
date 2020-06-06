/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufps.arquitectura.service;

import com.ufps.arquitectura.valueObject.EmpresaProductoPedido;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ufps.arquitectura.dao.IEmpresaProductoPedidoDao;


/**
 *
 * @author jjcarrillo
 */
@Service
public class EmpresaProductoPedidoServiceImpl implements IEmpresaProductoPedidoService{
    @Autowired
    private IEmpresaProductoPedidoDao productoPedidoDao;

    @Override
    @Transactional(readOnly=true)
    public List<EmpresaProductoPedido> findAll() {
        return (List<EmpresaProductoPedido>) productoPedidoDao.findAll();
    }

    @Override
    @Transactional
    public void save(EmpresaProductoPedido productoPedido) {
        productoPedidoDao.save(productoPedido);
    }

    @Override
    @Transactional(readOnly=true)
    public EmpresaProductoPedido findById(Long id) {
        return productoPedidoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        productoPedidoDao.deleteById(id);
    }

}
