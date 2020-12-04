package com.grupo.xxiv.convenios.model.service.impl;

import com.grupo.xxiv.convenios.converter.ConvenioMapper;
import com.grupo.xxiv.convenios.model.dao.IConvenioDao;
import com.grupo.xxiv.convenios.model.domain.ConvenioDomain;
import com.grupo.xxiv.convenios.model.dto.RespuestaGenericaDto;
import com.grupo.xxiv.convenios.model.entity.ConvenioEntity;
import com.grupo.xxiv.convenios.model.service.ConvenioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ConvenioServiceImpl implements ConvenioService {

    @Autowired
    private IConvenioDao iConvenioDao;

    @Autowired
    private ConvenioMapper convenioMapper;

    protected CrudRepository<ConvenioEntity, Long> getDao() {
        return iConvenioDao;
    }

    @Override
    public RespuestaGenericaDto insert(ConvenioDomain domain) {
        return null;
    }

    @Override
    public RespuestaGenericaDto update(ConvenioDomain domain) {
        if (!getDao().existsById(domain.getId())) {
            return RespuestaGenericaDto.error("No se encontro la institucion " + domain.getId());
        }
        ConvenioEntity e = convenioMapper.convertToEntity(domain);
        return RespuestaGenericaDto.ok(getDao().save(e));
    }

    @Override
    public RespuestaGenericaDto delete(Long id) {
        ConvenioEntity e = getDao().findById(id).orElse(null);
        if (Objects.isNull(e)) {
            return RespuestaGenericaDto.error("No se encontro la institucion " + id);
        }
        getDao().deleteById(id);
        return RespuestaGenericaDto.ok(null);
    }

    public RespuestaGenericaDto listAll() {
        List<ConvenioDomain> convenioDomains = new ArrayList<>();
        getDao().findAll().forEach(
                ce -> convenioDomains.add(convenioMapper.convertToDomain(ce))
        );
        return RespuestaGenericaDto.ok(convenioDomains);
    }

    @Override
    public RespuestaGenericaDto findById(Long id) {
        ConvenioEntity ce = iConvenioDao.findById(id).orElse(null);
        if (Objects.isNull(ce)) {
            return RespuestaGenericaDto.error("No se encontro Convenio");
        }
        return RespuestaGenericaDto.ok(ce);
    }

}
