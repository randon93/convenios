package com.grupo.xxiv.convenios.model.dao;

import com.grupo.xxiv.convenios.model.entity.Convenio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IConvenioDao extends JpaRepository<Convenio, Long> {
}
