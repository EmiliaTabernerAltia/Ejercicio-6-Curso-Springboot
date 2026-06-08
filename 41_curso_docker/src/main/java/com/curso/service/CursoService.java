package com.curso.service;

import java.util.List;

import com.curso.model.Curso;

public interface CursoService {

	List <Curso> cursos();
	Curso buscarCurso(String codCurso);
	void altaCurso(Curso libro);
	void actualizarCurso(Curso libro);
	List <Curso> eliminarCurso(String codCurso);
	List <Curso> cursosPrecio(int precioMin, int precioMax);
}
