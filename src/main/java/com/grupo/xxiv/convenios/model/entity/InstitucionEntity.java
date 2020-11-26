package com.grupo.xxiv.convenios.model.entity;

import common.types.Entity;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "institucion")
@Data
public class InstitucionEntity extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String correo;

    private String direccion;

    private String telefono;
}
