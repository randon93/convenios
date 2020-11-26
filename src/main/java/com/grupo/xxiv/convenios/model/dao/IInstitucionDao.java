package com.grupo.xxiv.convenios.model.dao;

import com.grupo.xxiv.convenios.model.entity.InstitucionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInstitucionDao extends JpaRepository<InstitucionEntity, Long> {

    InstitucionEntity findByCorreo(String correo);

    InstitucionEntity findByNombre(String nombre);
}
