package com.api.demo.encuesta.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.api.demo.encuesta.entity.Encuesta;

public interface EncuestaRepository extends JpaRepository<Encuesta, Long>{
}
