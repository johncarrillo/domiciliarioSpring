/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufps.arquitectura.service;

import com.ufps.arquitectura.dao.IDomiciliarioDao;
import com.ufps.arquitectura.valueObject.Domiciliario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author jjcarrillo
 */
@Service
public class DomiliciarioServiceImpl implements IDomiciliarioService{
    @Autowired
    private IDomiciliarioDao domiciliarioDao;

    @Override
    @Transactional(readOnly=true)
    public List<Domiciliario> findAll() {
        return (List<Domiciliario>) domiciliarioDao.findAll();
    }

    @Override
    @Transactional
    public void save(Domiciliario domiciliario) {
        domiciliarioDao.save(domiciliario);
    }

    @Override
    @Transactional(readOnly=true)
    public Domiciliario findById(Long id) {
        return domiciliarioDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        domiciliarioDao.deleteById(id);
    }

}
