package com.api.demo.encuesta.service;

import java.util.List;
import com.api.demo.encuesta.entity.Encuesta;

public interface EncuestaService {
    
    public Encuesta addEncuesta(Encuesta encuesta);

    public List<Encuesta> findAll();
}
