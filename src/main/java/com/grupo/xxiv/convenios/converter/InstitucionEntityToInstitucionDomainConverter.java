package com.grupo.xxiv.convenios.converter;

import com.grupo.xxiv.convenios.converter.mapper.InstitucionMapper;
import com.grupo.xxiv.convenios.model.domain.InstitucionDomain;
import com.grupo.xxiv.convenios.model.entity.InstitucionEntity;
import org.springframework.core.convert.converter.Converter;

public class InstitucionEntityToInstitucionDomainConverter implements Converter<InstitucionEntity, InstitucionDomain> {

    @Override
    public InstitucionDomain convert(InstitucionEntity entity) {
        return InstitucionMapper.INSTANSE.entityToDomain(entity);
    }
}
