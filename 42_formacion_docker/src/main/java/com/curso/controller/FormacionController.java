package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Formacion;
import com.curso.service.FormacionService;

@RestController
public class FormacionController {
	
	@Autowired
    FormacionService service;

    @GetMapping("formaciones")
    public List<Formacion> obtener() {
        return service.obtenerFormaciones();
    }

    @PostMapping("formacion")
    public void alta(@RequestBody Formacion formacion) {
        service.altaFormacion(formacion);
    }
    
}
