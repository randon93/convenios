package com.grupo.xxiv.convenios.model.domain;

import common.types.DomainBean;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AdministradorDomain extends DomainBean<Long> {

    private Long id;
    private String nombre;
    private String apellido;
    private String correo;
    private String contraseña;
}
