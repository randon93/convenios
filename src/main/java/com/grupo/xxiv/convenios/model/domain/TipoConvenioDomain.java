package com.grupo.xxiv.convenios.model.domain;

import common.types.DomainBean;
import lombok.Data;

import java.util.List;

@Data
public class TipoConvenioDomain extends DomainBean<Long> {

    private Long id;
    private String nombre;
    private List<Long> convenios;
}
