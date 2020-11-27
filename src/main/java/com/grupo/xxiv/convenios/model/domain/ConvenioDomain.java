package com.grupo.xxiv.convenios.model.domain;

import com.grupo.xxiv.convenios.model.entity.DepartamentoEntity;
import com.grupo.xxiv.convenios.model.entity.InstitucionEntity;
import com.grupo.xxiv.convenios.model.entity.TipoConvenio;
import common.types.DomainBean;
import lombok.Data;

import java.util.Date;

@Data
public class ConvenioDomain extends DomainBean<Long> {

    private Long id;
    private String nombre;
    private Date fechaInicio;
    private Date fechaFin;
    private InstitucionEntity institucionEntity;
    private DepartamentoEntity departamentoEntity;
    private TipoConvenio tipoConvenio;
}
