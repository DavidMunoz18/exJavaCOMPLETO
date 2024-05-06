package Servicios;

import java.util.List;

import Dtos.CitasDto;

public interface OperativaInterfaz {

	
	public void darAltaCita(List<CitasDto> listaCitas, String rutaLog);
	
	public void registroLlegada(List<CitasDto> listaCitas, String rutaLog);
	
	public void mostrarConsultasPsicologia(List<CitasDto> listaCitas, String rutaLog);
	public void mostrarConsultasTraumatologia(List<CitasDto> listaCitas, String rutaLog);
	public void mostrarConsultasFisioterapia(List<CitasDto> listaCitas, String rutaLog);
	
	public void cargarDatos(List<CitasDto> listaCitas, String rutaCitas);
	
}
