/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufps.arquitectura.service;

import com.ufps.arquitectura.dao.IProductoDao;
import com.ufps.arquitectura.valueObject.Producto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author jjcarrillo
 */
@Service
public class ProductoServiceImpl implements IProductoService{
    @Autowired
    private IProductoDao productoDao;

    @Override
    @Transactional(readOnly=true)
    public List<Producto> findAll() {
        return (List<Producto>) productoDao.findAll();
    }

    @Override
    @Transactional
    public void save(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    @Transactional(readOnly=true)
    public Producto findById(Long id) {
        return productoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        productoDao.deleteById(id);
    }

}
