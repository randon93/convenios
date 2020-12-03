package com.grupo.xxiv.convenios.converter;

import com.grupo.xxiv.convenios.model.domain.ConvenioDomain;
import com.grupo.xxiv.convenios.model.domain.InstitucionDomain;
import com.grupo.xxiv.convenios.model.entity.ConvenioEntity;
import com.grupo.xxiv.convenios.model.entity.InstitucionEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ConvenioMapper {

    @Autowired
    private ModelMapper modelMapper;


    public ConvenioDomain convertToDomain(ConvenioEntity entity) {
        ConvenioDomain domain = modelMapper.map(entity, ConvenioDomain.class);
        return domain;
    }

    public ConvenioEntity convertToEntity(ConvenioDomain domain) {
        ConvenioEntity entity = modelMapper.map(domain, ConvenioEntity.class);
        return entity;
    }
}
