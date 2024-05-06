package Controladores;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import Dtos.CitasDto;
import Servicios.FicherosImplementacion;
import Servicios.FicherosInterfaz;
import Servicios.MenuImplementacion;
import Servicios.MenuInterfaz;
import Servicios.OperativaImplementacion;
import Servicios.OperativaInterfaz;

public class Inicio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		LocalDate fechaHoy = LocalDate.now();
		
		String ruta = "citasConAsistencia" + "-" + fechaHoy.format(dateTimeFormatter).replace("-", "");
		String rutaLog ="log" + "-" + fechaHoy.format(dateTimeFormatter).replace("-", "");
		String rutaCitas ="Citas" + "-" + fechaHoy.format(dateTimeFormatter).replace("-", "") + ".txt";
		
		List<CitasDto> listaCitas = new ArrayList<CitasDto>();
		MenuInterfaz mi = new MenuImplementacion();
		OperativaInterfaz oi = new OperativaImplementacion();
		FicherosInterfaz fi = new FicherosImplementacion();
		
		try {
			
			oi.cargarDatos(listaCitas, rutaCitas);
			
			String mensaje;
			
			 mensaje = "Se inicia la aplicacion";
			fi.escribirFicheroLog(rutaLog, mensaje );
		
		boolean cerrarMenu = false;
		int opcion;
		while(!cerrarMenu) {
			
			opcion = mi.mostrarMenuYSeleccionPrincipal();
			switch (opcion) {
			case 0:
				
				FileWriter fileWriter = new FileWriter(rutaCitas);
				PrintWriter printWriter = new PrintWriter(fileWriter);
				for (CitasDto citasDto : listaCitas) {
					
					
					String mensaje2 = citasDto.getId() + ";" + citasDto.getDni() + ";" + citasDto.getNombre() + ";" + citasDto.getApellidos() + ";" + citasDto.getEspecialidad() + ";" + citasDto.getFechaCita() + ";";
					
					printWriter.write(mensaje2 + "\n");
					
					
				}	
				fileWriter.close();
				cerrarMenu = true;
				break;
			case 1:
				oi.darAltaCita(listaCitas, rutaLog);
				break;
			case 2:
				oi.registroLlegada(listaCitas, rutaLog);
				break;
			case 3:
				int opcionFuncionalidades = mi.mostrarFuncionalidades();
				switch (opcionFuncionalidades) {
				case 0:
					break;
				case 1:
					int opcionConsultas = mi.seleccionarConsultas();
					switch (opcionConsultas) {
					case 0:
						break;
					case 1:
						oi.mostrarConsultasPsicologia(listaCitas,rutaLog);
						break;
					case 2:
						oi.mostrarConsultasTraumatologia(listaCitas, rutaLog);
						break;
					case 3:
						oi.mostrarConsultasFisioterapia(listaCitas, rutaLog);
						break;

					default:
						System.out.println("La opcion seleccionada no existe");
						break;
					}
					break;
				case 2:
					int opcionConsultas2 = mi.seleccionarConsultas();
					switch (opcionConsultas2) {
					case 0:
						break;
					case 1:
						fi.escribirConsultasPsicologia(listaCitas, ruta, rutaLog);
						break;
					case 2:
						fi.escribirConsultasTraumatologia(listaCitas, ruta, rutaLog);
						break;
					case 3:
						fi.escribirConsultasFisioterapia(listaCitas, ruta, rutaLog);
						break;
					default:
						break;
					}
					break;
					
				default:
					System.out.println("La opcion seleccionada no existe");
					break;
				}
				break;

			default:
				System.out.println("La opcion seleccionada no existe");
				break;
			}
			
		}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
