package com.grupo.xxiv.convenios.model.domain;

import common.types.DomainBean;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ConvenioDomain extends DomainBean<Long> {

    private Long id;
    private String nombre;
    private Date fechaInicio;
    private Date fechaFin;
    private InstitucionDomain institucionDomain;
    private DepartamentoDomain departamentoDomain;
    private TipoConvenioDomain tipoConvenioDomain;
    private List<DocumentoDomain> documentoDomains;
}
