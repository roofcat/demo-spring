package com.crojas.demo.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class ContactoForm {
	
	
	@NotNull(message = "no puede ser nulo")
	@NotBlank(message = "no puede ser en blanco")
	private String nombre;
	
	@NotNull(message = "no puede ser nulo")
	@NotBlank(message = "no puede ser en blanco")
	private String apellido;
	
	
	public String getNombre() {
		return nombre;
	}
	
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public String getApellido() {
		return apellido;
	}
	
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
}
