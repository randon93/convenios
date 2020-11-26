package com.grupo.xxiv.convenios.model.service.impl;

import com.grupo.xxiv.convenios.model.dao.IInstitucionDao;
import com.grupo.xxiv.convenios.model.domain.InstitucionDomain;
import com.grupo.xxiv.convenios.model.entity.InstitucionEntity;
import com.grupo.xxiv.convenios.model.service.InstitucionService;
import common.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class InstitucionServiceImpl
        extends ServiceImpl<InstitucionDomain, InstitucionEntity, Long>
        implements InstitucionService {

    @Autowired
    private IInstitucionDao iInstitucionDao;


    @Override
    protected CrudRepository<InstitucionEntity, Long> getDao() {
        return iInstitucionDao;
    }
}
