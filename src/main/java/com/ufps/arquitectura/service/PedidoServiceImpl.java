/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufps.arquitectura.service;

import com.ufps.arquitectura.dao.IPedidoDao;
import com.ufps.arquitectura.valueObject.Pedido;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author jjcarrillo
 */
@Service
public class PedidoServiceImpl implements IPedidoService{
    @Autowired
    private IPedidoDao pedidoDao;

    @Override
    @Transactional(readOnly=true)
    public List<Pedido> findAll() {
        return (List<Pedido>) pedidoDao.findAll();
    }

    @Override
    @Transactional
    public void save(Pedido pedido) {
        pedidoDao.save(pedido);
    }

    @Override
    @Transactional(readOnly=true)
    public Pedido findById(Long id) {
        return pedidoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        pedidoDao.deleteById(id);
    }

}
