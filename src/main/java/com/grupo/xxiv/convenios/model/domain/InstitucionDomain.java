package com.grupo.xxiv.convenios.model.domain;

import common.types.DomainBean;
import lombok.Data;

@Data
public class InstitucionDomain extends DomainBean<Long> {

    private Long id;

    private String nombre;

    private String correo;

    private String direccion;

    private String telefono;

}
