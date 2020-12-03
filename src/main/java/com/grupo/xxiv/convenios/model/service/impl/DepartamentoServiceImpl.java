package com.grupo.xxiv.convenios.model.service.impl;

import com.grupo.xxiv.convenios.model.dao.IDepartamentoDao;
import com.grupo.xxiv.convenios.model.domain.DepartamentoDomain;
import com.grupo.xxiv.convenios.model.dto.RespuestaGenericaDto;
import com.grupo.xxiv.convenios.model.entity.DepartamentoEntity;
import com.grupo.xxiv.convenios.model.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

    @Autowired
    private IDepartamentoDao departamentoDao;

    protected CrudRepository<DepartamentoEntity, Long> getDao() {
        return departamentoDao;
    }

    @Override
    public RespuestaGenericaDto insert(DepartamentoDomain domain) {
        return null;
    }

    @Override
    public RespuestaGenericaDto update(DepartamentoDomain domain) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public RespuestaGenericaDto listAll() {
        return null;
    }
}
