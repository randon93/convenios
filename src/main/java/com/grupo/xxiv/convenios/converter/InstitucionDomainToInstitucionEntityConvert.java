package com.grupo.xxiv.convenios.converter;

import com.grupo.xxiv.convenios.converter.mapper.InstitucionMapper;
import com.grupo.xxiv.convenios.model.domain.InstitucionDomain;
import com.grupo.xxiv.convenios.model.entity.InstitucionEntity;
import org.springframework.core.convert.converter.Converter;

public class InstitucionDomainToInstitucionEntityConvert implements Converter<InstitucionDomain, InstitucionEntity> {

    @Override
    public InstitucionEntity convert(InstitucionDomain domain) {
        return InstitucionMapper.INSTANSE.domainToEntity(domain);
    }
}
