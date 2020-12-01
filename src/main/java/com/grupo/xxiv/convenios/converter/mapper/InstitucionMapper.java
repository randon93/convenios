package com.grupo.xxiv.convenios.converter.mapper;

import com.grupo.xxiv.convenios.model.domain.InstitucionDomain;
import com.grupo.xxiv.convenios.model.entity.InstitucionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InstitucionMapper  {

        InstitucionMapper INSTANSE = Mappers.getMapper(InstitucionMapper.class);

        InstitucionDomain entityToDomain(InstitucionEntity entity);

        InstitucionEntity domainToEntity(InstitucionDomain domain);
}
