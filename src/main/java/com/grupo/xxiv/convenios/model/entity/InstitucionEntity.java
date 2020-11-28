package com.grupo.xxiv.convenios.model.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "institucion")
@Entity
@Data
public class InstitucionEntity extends common.types.Entity<Long> {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String correo;

    private String direccion;

    private String telefono;
}
