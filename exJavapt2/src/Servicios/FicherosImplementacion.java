package Servicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import Dtos.CitasDto;

public class FicherosImplementacion implements FicherosInterfaz {

	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	Scanner sc = new Scanner(System.in);
	@Override
	public void escribirConsultasPsicologia(List<CitasDto> listaCitas,  String ruta, String rutaLog) {
		System.out.println("Introduzca la fecha (yyyy-MM-dd)");
		String fechaUsu = sc.next();
		
		
		

		try {
			FileWriter fileWriter = new FileWriter(ruta);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			
						
			for (CitasDto citasDto : listaCitas) {
				if(fechaUsu.equals(citasDto.getFechaCita().format(dateTimeFormatter)) && citasDto.getEspecialidad().equals("Psicologia")) {
					
					printWriter.write("Nombre Completo" + citasDto.getNombre().concat(" ").concat(citasDto.getApellidos()));
					fileWriter.close();
				}
			}
		} catch (IOException e) {
			
			String mensaje = "El error es" + e.getMessage();
			
			escribirFicheroLog(rutaLog, fechaUsu);
		}
		
		
	}

	@Override
	public void escribirConsultasTraumatologia(List<CitasDto> listaCitas,  String ruta, String rutaLog) {
		System.out.println("Introduzca la fecha (yyyy-MM-dd)");
		String fechaUsu = sc.next();
		
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(ruta);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			
			for (CitasDto citasDto : listaCitas) {
				if(fechaUsu.equals(citasDto.getFechaCita().format(dateTimeFormatter)) && citasDto.getEspecialidad().equals("Traumatologia")) {
					
					printWriter.write("Nombre Completo" + citasDto.getNombre().concat(" ").concat(citasDto.getApellidos()));
					fileWriter.close();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void escribirConsultasFisioterapia(List<CitasDto> listaCitas,  String ruta, String rutaLog) {
		System.out.println("Introduzca la fecha (yyyy-MM-dd)");
		String fechaUsu = sc.next();
		
		
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(ruta);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			
			for (CitasDto citasDto : listaCitas) {
				if(fechaUsu.equals(citasDto.getFechaCita().format(dateTimeFormatter)) && citasDto.getEspecialidad().equals("Fisioterapia")) {
					
					printWriter.write("Nombre Completo" + citasDto.getNombre().concat(" ").concat(citasDto.getApellidos()));
					fileWriter.close();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void escribirFicheroLog(String rutaLog, String mensajeLog) {
		
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(rutaLog , true);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			
			printWriter.write(mensajeLog);
			
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
