package com.api.demo.encuesta.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.demo.encuesta.dto.EncuestaRequest;
import com.api.demo.encuesta.entity.Encuesta;
import com.api.demo.encuesta.service.EncuestaService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping(value = "/api")
public class EncuestaController {
    
    @Autowired
    private EncuestaService encuestaService;

    Encuesta encuesta = new Encuesta();

    @PostMapping(value = "/guardar/encuesta")
    public ResponseEntity<?> saveEncuesta(@RequestBody EncuestaRequest req){

        encuesta = new Encuesta();
        encuesta.setEstiloMusical(req.getEstiloMusical());
        encuesta.setEmail(req.getEmail());
        encuesta = encuestaService.addEncuesta(encuesta);
        if(encuesta != null){
            return new ResponseEntity<>(encuesta, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Transaccion no se genero correctamente", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/obtener/resultados")
    public ResponseEntity<?> getAllResults(){

        List<Encuesta> list = encuestaService.findAll().stream().map(lista -> lista).collect(Collectors.toList());
        if(list.size()>0){
            return new ResponseEntity<>(list, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Recurso no encontrado", HttpStatus.NOT_FOUND);
        }
    }
}
