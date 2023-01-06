package com.api.demo.encuesta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.demo.encuesta.entity.Encuesta;
import com.api.demo.encuesta.repository.EncuestaRepository;

@Service
public class EncuestaServiceImp implements EncuestaService {

    @Autowired
    EncuestaRepository encuestaRepository;

    @Override
    public Encuesta addEncuesta(Encuesta encuesta) {
        
        return encuestaRepository.save(encuesta);
    }

    @Override
    public List<Encuesta> findAll() {
        
        return encuestaRepository.findAll();
    }

   
    
}
