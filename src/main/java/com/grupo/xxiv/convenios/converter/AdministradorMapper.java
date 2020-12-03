package com.grupo.xxiv.convenios.converter;

import com.grupo.xxiv.convenios.model.domain.AdministradorDomain;
import com.grupo.xxiv.convenios.model.domain.DocumentoDomain;
import com.grupo.xxiv.convenios.model.entity.AdministradorEntity;
import com.grupo.xxiv.convenios.model.entity.DocumentoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class AdministradorMapper {

    @Autowired
    private ModelMapper modelMapper;


    public AdministradorDomain convertToDomain(AdministradorEntity entity) {
        AdministradorDomain domain = modelMapper.map(entity, AdministradorDomain.class);
        return domain;
    }

    public AdministradorEntity convertToEntity(AdministradorDomain domain) {
        AdministradorEntity entity = modelMapper.map(domain, AdministradorEntity.class);
        return entity;
    }
}
