package com.grupo.xxiv.convenios.model.dao;

import com.grupo.xxiv.convenios.model.entity.Institucion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInstitucionDao extends JpaRepository<Institucion, Long> {

    Institucion findByCorreo(String correo);

    Institucion findByNombre(String nombre);
}
