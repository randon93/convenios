package com.grupo.xxiv.convenios.converter;

import com.grupo.xxiv.convenios.model.domain.ConvenioDomain;
import com.grupo.xxiv.convenios.model.domain.DepartamentoDomain;
import com.grupo.xxiv.convenios.model.entity.ConvenioEntity;
import com.grupo.xxiv.convenios.model.entity.DepartamentoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class DepartamentoMapper {

    @Autowired
    private ModelMapper modelMapper;


    public DepartamentoDomain convertToDomain(DepartamentoEntity entity) {
        DepartamentoDomain domain = modelMapper.map(entity, DepartamentoDomain.class);
        return domain;
    }

    public DepartamentoEntity convertToEntity(DepartamentoDomain domain) {
        DepartamentoEntity entity = modelMapper.map(domain, DepartamentoEntity.class);
        return entity;
    }
}
