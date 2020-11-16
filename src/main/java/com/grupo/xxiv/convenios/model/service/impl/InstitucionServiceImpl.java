package com.grupo.xxiv.convenios.model.service.impl;

import com.grupo.xxiv.convenios.model.dao.IInstitucionDao;
import com.grupo.xxiv.convenios.model.entity.Institucion;
import com.grupo.xxiv.convenios.model.service.InstitucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstitucionServiceImpl implements InstitucionService {

    @Autowired
    private IInstitucionDao iInstitucionDao;

    @Override
    public Institucion findById(Long id) {
        return null;
    }

    @Override
    public List<Institucion> findByNombreLikeIgnoreCase(String name) {
        return null;
    }

    @Override
    public Institucion save(Institucion institucion) {
       return iInstitucionDao.save(institucion);
    }

    @Override
    public Institucion findByNumInventario(String nombre) {
        return null;
    }

    @Override
    public List<Institucion> findAll() {
        return iInstitucionDao.findAll();
    }
}
