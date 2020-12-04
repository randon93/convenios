package com.grupo.xxiv.convenios.model.service.impl;

import com.grupo.xxiv.convenios.converter.TipoConvenioMapper;
import com.grupo.xxiv.convenios.model.dao.TipoConvenioDao;
import com.grupo.xxiv.convenios.model.domain.TipoConvenioDomain;
import com.grupo.xxiv.convenios.model.dto.RespuestaGenericaDto;
import com.grupo.xxiv.convenios.model.entity.TipoConvenioEntity;
import com.grupo.xxiv.convenios.model.service.TipoConvenioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class TipoConvenioServiceImpl implements TipoConvenioService {

    @Autowired
    private TipoConvenioDao tipoConvenioDao;

    @Autowired
    private TipoConvenioMapper tipoConvenioMapper;

    protected CrudRepository<TipoConvenioEntity, Long> getDao() {
        return tipoConvenioDao;
    }

    @Override
    public RespuestaGenericaDto insert(TipoConvenioDomain domain) {
        if (Objects.isNull(domain)) {
            return RespuestaGenericaDto.error("Informacion vacia");
        }
        TipoConvenioEntity e = tipoConvenioMapper.convertToEntity(domain);
        if (Objects.isNull(e)) {
            return RespuestaGenericaDto.error("Ocurrio un error en Converter Institucion");
        }
        Long id = getDao().save(e).getId();
        return RespuestaGenericaDto.ok(id);
    }

    @Override
    public RespuestaGenericaDto update(TipoConvenioDomain domain) {
        if (!getDao().existsById(domain.getId())) {
            return RespuestaGenericaDto.error("No se encontro la institucion " + domain.getId());
        }
        TipoConvenioEntity e = tipoConvenioMapper.convertToEntity(domain);
        return RespuestaGenericaDto.ok(getDao().save(e));
    }

    @Override
    public RespuestaGenericaDto delete(Long id) {
        TipoConvenioEntity e = getDao().findById(id).orElse(null);
        if (Objects.isNull(e)) {
            return RespuestaGenericaDto.error("No se encontro la institucion " + id);
        }
        getDao().deleteById(id);
        return RespuestaGenericaDto.ok(null);
    }

    @Override
    public RespuestaGenericaDto listAll() {
        List<TipoConvenioDomain> tipoConvenioDomains = new ArrayList<>();
        getDao().findAll().forEach(
                tcd -> tipoConvenioDomains.add(tipoConvenioMapper.convertToDomain(tcd))
        );
        return RespuestaGenericaDto.ok(tipoConvenioDomains);
    }
}
