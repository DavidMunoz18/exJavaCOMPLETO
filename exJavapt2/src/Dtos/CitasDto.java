package Dtos;

import java.time.LocalDate;

public class CitasDto {

	long id;
	String dni = "aaaaa";
	String nombre = "aaaaa";
	String apellidos= "aaaaa";
	String especialidad= "aaaaa";
	LocalDate fechaCita = LocalDate.now();
	boolean asistencia = false;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public LocalDate getFechaCita() {
		return fechaCita;
	}
	public void setFechaCita(LocalDate fechaCita) {
		this.fechaCita = fechaCita;
	}
	public boolean isAsistencia() {
		return asistencia;
	}
	public void setAsistencia(boolean asistencia) {
		this.asistencia = asistencia;
	}
	public CitasDto() {
		super();
	}
	public CitasDto(String dni, String nombre, String apellidos, String especialidad, LocalDate fechaCita,
			boolean asistencia) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.especialidad = especialidad;
		this.fechaCita = fechaCita;
		this.asistencia = asistencia;
	}
	
	
}
