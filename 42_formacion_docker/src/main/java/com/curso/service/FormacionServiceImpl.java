package com.curso.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.model.Curso;
import com.curso.model.Formacion;

@Service
public class FormacionServiceImpl  implements FormacionService{

	@Autowired
    private RestTemplate restTemplate;

    private String urlCursos = "http://localhost:8081/";

    public List<Formacion> obtenerFormaciones() {

        Curso[] cursos = restTemplate.getForObject(
                urlCursos + "cursos", Curso[].class);

        return Arrays.stream(cursos)
                .map(c -> {
                    Formacion f = new Formacion();
                    f.setCurso(c.getNombre()+String.valueOf(c.getDuracion()));
                    f.setPrecio(c.getPrecio());

                    if (c.getDuracion() >= 50) {
                        f.setAsignaturas(10);
                    } else {
                        f.setAsignaturas(5);
                    }

                    return f;
                })
                .toList();
    }
    
    public void altaFormacion(Formacion formacion) {
        
        Curso[] cursos = restTemplate.getForObject(
                urlCursos + "cursos", Curso[].class);

       
        boolean existe = Arrays.stream(cursos)
                .anyMatch(c -> c.getNombre()
                .equalsIgnoreCase(formacion.getCurso()));

        if (existe) {
            return; 
        }


        Curso curso = new Curso();

        curso.setNombre(formacion.getCurso());
        curso.setPrecio((int) formacion.getPrecio());

        
        int duracion = formacion.getAsignaturas() * 10;
        curso.setDuracion(duracion);

        
        String codigo = formacion.getCurso()
                .substring(0, 3)
                .toLowerCase() + duracion;

        curso.setCodCurso(codigo);

        
        restTemplate.postForLocation(urlCursos + "curso", curso);
    }
}
