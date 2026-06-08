package com.curso.model;

public class Curso {

	private String codCurso;
	
	private int duracion, precio;

	private String nombre;
	
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getCodCurso() {
		return codCurso;
	}
	public void setCodCurso(String codCurso) {
		this.codCurso = codCurso;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Curso(String codCurso, String nombre , int duracion, int precio) {
		super();
		this.duracion = duracion;
		this.precio = precio;
		this.codCurso = codCurso;
		this.nombre = nombre;
	}
	public Curso() {
		super();
	}
	
	
	
}
