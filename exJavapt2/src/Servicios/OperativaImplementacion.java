package Servicios;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import Dtos.CitasDto;

public class OperativaImplementacion implements OperativaInterfaz {

	Scanner sc = new Scanner(System.in);
	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	FicherosInterfaz fi = new FicherosImplementacion();
	
	String mensaje;
	
	@Override
	public void darAltaCita(List<CitasDto> listaCitas, String rutaLog) {
		
		mensaje = "Entra en dar alta cita :)";
		
		
			fi.escribirFicheroLog(rutaLog, mensaje);
			
			CitasDto citas = crearNuevaCita(listaCitas);
			
			listaCitas.add(citas);
		
		
		
	}
	private CitasDto crearNuevaCita(List<CitasDto> listaCitas) {
		
		CitasDto citas = new CitasDto();
		
		citas.setId(idAutogenerado(listaCitas));
				
		System.out.println("ID: " + citas.getId());
		
		System.out.println("Introduzca el dni");
		citas.setDni(sc.next());
		
		System.out.println("Introduzca el nombre ");
		citas.setNombre(sc.next());
		
		System.out.println("Introduzca el apellido ");
		citas.setApellidos(sc.next());
		
		System.out.println("Introduzca la especialidad ");
		citas.setEspecialidad(sc.next());
		
		System.out.println("Introduzca la fecha de la cita (yyyy-MM-dd) ");
		citas.setFechaCita(LocalDate.parse(sc.next(), dateTimeFormatter));
		
		
		
		return citas;
	}
	@Override
	public void registroLlegada(List<CitasDto> listaCitas, String rutaLog) {
		
		
		try {
			
			mensaje = "Entra en registro llegada :)";
			
			fi.escribirFicheroLog(rutaLog, mensaje);
			
			char[] letrasDni = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E' };
			
			
			System.out.println("Introduzca su dni (numero)");
			int numeroDni = sc.nextInt();
			
			System.out.println("Introduzca su dni (letra)");
			char letraDni = sc.next().charAt(0);
			
			int resto = numeroDni % 23;
			
			LocalDate localDate = LocalDate.now();
			
			String dniJunto = String.valueOf(numeroDni).concat(String.valueOf(letraDni));
			
			for (CitasDto citas : listaCitas) {
				if(letrasDni[resto] == letraDni && citas.getDni().equals(dniJunto) && citas.getFechaCita().equals(localDate)) {
					
					citas.setAsistencia(true);
					
					System.out.println("Espere su turno para la consulta de Psicología en la sala de espera. Su especialista le avisará.");
				}
				else {
					System.out.println(" No dispone de cita previa para hoy.");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Override
	public void mostrarConsultasPsicologia(List<CitasDto> listaCitas, String rutaLog) {
		
		
		
		System.out.println("Introduzca la fecha (yyyy-MM-dd)");
		String fechaUsu = sc.next();
		
		for (CitasDto citasDto : listaCitas) {
			if(fechaUsu.equals(citasDto.getFechaCita().format(dateTimeFormatter)) && citasDto.getEspecialidad().equals("Psicologia")) {
				
				System.out.println("Nombre Completo" + citasDto.getNombre().concat(" ").concat(citasDto.getApellidos()));
				
			}
		}
		
	}
	@Override
	public void mostrarConsultasTraumatologia(List<CitasDto> listaCitas, String rutaLog) {
		System.out.println("Introduzca la fecha (yyyy-MM-dd)");
		String fechaUsu = sc.next();
		
		for (CitasDto citasDto : listaCitas) {
			if(fechaUsu.equals(citasDto.getFechaCita().format(dateTimeFormatter)) && citasDto.getEspecialidad().equals("Traumatologia")) {
				
				System.out.println("Nombre Completo" + citasDto.getNombre().concat(" ").concat(citasDto.getApellidos()));
				
			}
		}
		
	}
	@Override
	public void mostrarConsultasFisioterapia(List<CitasDto> listaCitas, String rutaLog) {
		System.out.println("Introduzca la fecha (yyyy-MM-dd)");
		String fechaUsu = sc.next();
		
		for (CitasDto citasDto : listaCitas) {
			if(fechaUsu.equals(citasDto.getFechaCita().format(dateTimeFormatter)) && citasDto.getEspecialidad().equals("Fisioterapia")) {
				
				System.out.println("Nombre Completo" + citasDto.getNombre().concat(" ").concat(citasDto.getApellidos()));
				
			}
		}
		
	}
	private long idAutogenerado(List<CitasDto> listaCitas) {
		
		long id;
		
		int tamanioLista = listaCitas.size();
		
		if(tamanioLista == 0) {
			id = 1;
		}
		else {
			id = listaCitas.get(tamanioLista -1).getId() +1;
		}
		return id;
		
	}
	@Override
	public void cargarDatos(List<CitasDto> listaCitas, String rutaCitas) {
		
		
		try {
			FileReader fileReader = new FileReader(rutaCitas);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			String linea;
			
			while((linea = bufferedReader.readLine()) != null) {
				
				String [] posiciones = linea.split(";");
				
				CitasDto citas = new CitasDto();
				
				citas.setId(Long.parseLong(posiciones[0]) );
				
				citas.setDni(posiciones[1]);
				
				citas.setNombre(posiciones[2]);
				
				citas.setApellidos(posiciones[3]);
				
				citas.setEspecialidad(posiciones[4]);
				
				citas.setFechaCita(LocalDate.parse(posiciones[5]));
				
				
				
				listaCitas.add(citas);
				
			}
				
			bufferedReader.close();	
			
		} catch (Exception e) {
			System.out.println("No existe ningun fichero:" + e.getMessage());
		}
		
		
		
	}
	

	
}
