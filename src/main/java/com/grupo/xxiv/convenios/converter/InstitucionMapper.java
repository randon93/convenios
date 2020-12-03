package com.grupo.xxiv.convenios.converter;

import com.grupo.xxiv.convenios.model.domain.InstitucionDomain;
import com.grupo.xxiv.convenios.model.entity.InstitucionEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InstitucionMapper {

    @Autowired
    private ModelMapper modelMapper;


    public InstitucionDomain convertToDomain(InstitucionEntity entity) {
        InstitucionDomain domain = modelMapper.map(entity, InstitucionDomain.class);
        return domain;
    }

    public InstitucionEntity convertToEntity(InstitucionDomain domain) {
        InstitucionEntity entity = modelMapper.map(domain, InstitucionEntity.class);
        return entity;
    }

}
