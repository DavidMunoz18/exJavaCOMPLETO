package Servicios;

import java.util.List;

import Dtos.CitasDto;

public interface FicherosInterfaz {

	public void escribirConsultasPsicologia(List<CitasDto> listaCitas, String ruta, String rutaLog);
	public void escribirConsultasTraumatologia(List<CitasDto> listaCitas,  String ruta, String rutaLog);
	public void escribirConsultasFisioterapia(List<CitasDto> listaCitas,  String ruta, String rutaLog);
	
	public void escribirFicheroLog(String rutaLog, String mensajeLog);
}
