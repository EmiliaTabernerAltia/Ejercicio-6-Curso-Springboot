package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Curso;
import com.curso.service.CursoService;


@RestController
public class CursoController {
	@Autowired
	CursoService service;
	
	@GetMapping(value="curso/{codCurso}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Curso buscarLibro(@PathVariable("codCurso") String codCurso) {
		return service.buscarCurso(codCurso);
	}
	
	@GetMapping(value="cursos", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> libros() {
		return service.cursos();
	}
	
	@PostMapping(value="curso", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void agregar(@RequestBody Curso curso) {
		service.altaCurso(curso);
	}
	
	@PutMapping(value="curso", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void actualizar(@RequestBody Curso curso) {
		service.actualizarCurso(curso);
	}
	
	@DeleteMapping(value="curso/{codCurso}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> eliminar (@PathVariable("codCurso") String codCurso){
		return service.eliminarCurso(codCurso);
	}
	
	@GetMapping(value="curso/precio/{precioMin}/{precioMax}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> buscarLibro(@PathVariable("precioMin") int precioMin, @PathVariable("precioMax") int precioMax) {
		return service.cursosPrecio(precioMin, precioMax);
	}
	
}
