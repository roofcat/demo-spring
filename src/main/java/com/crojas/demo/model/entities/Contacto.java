package com.crojas.demo.model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.crojas.demo.config.common.ColumnPosition;


@Entity
@Table(name="DEMO_CONTACTO")
public class Contacto implements Serializable {
	
	
	private static final long serialVersionUID = -6744255850429201769L;
	
	
	@ColumnPosition(position = 0)
	@SequenceGenerator(name = "SEQ_CONTACTO_ID", sequenceName = "SEQ_CONTACTO", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CONTACTO_ID")
	@Id
	@Column(name="ID", nullable=false, insertable=false)
	private Integer id;
	
	
	@ColumnPosition(position = 1)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHA", nullable = false)
	private Date fecha;
	
	
	@ColumnPosition(position = 2)
	@Column(name = "NOMBRE", nullable = false)
	private String nombre;
	
	
	@ColumnPosition(position=3)
	@Column(name="CORREO", nullable=false)
	private String correo;
	
	
	@ColumnPosition(position = 4)
	@Column(name = "MENSAJE", nullable = false)
	private String mensaje;
	
	
	public Integer getId() {
		return id;
	}
	
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public Date getFecha() {
		return fecha;
	}
	
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public String getCorreo() {
		return correo;
	}
	
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
	public String getMensaje() {
		return mensaje;
	}
	
	
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
}
