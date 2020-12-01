package com.grupo.xxiv.convenios.model.service.impl;

import com.grupo.xxiv.convenios.model.dao.IDepartamentoDao;
import com.grupo.xxiv.convenios.model.domain.DepartamentoDomain;
import com.grupo.xxiv.convenios.model.entity.DepartamentoEntity;
import com.grupo.xxiv.convenios.model.service.DepartamentoService;
import common.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartamentoServiceImpl
        extends ServiceImpl<DepartamentoDomain, DepartamentoEntity, Long> implements DepartamentoService {

    @Autowired
    private IDepartamentoDao departamentoDao;

    @Override
    protected CrudRepository<DepartamentoEntity, Long> getDao() {
        return departamentoDao;
    }
}
