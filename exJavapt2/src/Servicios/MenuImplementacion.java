package Servicios;

import java.util.Scanner;

public class MenuImplementacion implements MenuInterfaz {

	Scanner sc = new Scanner(System.in);
	
	@Override
	public int mostrarMenuYSeleccionPrincipal() {
		int opcion;
		System.out.println("------------------------------");
		System.out.println("|0. Cerrar menu               |");
		System.out.println("|1. Dar alta                  |");
		System.out.println("|2. Registro de llegada       |");
		System.out.println("|3. Listado de consultas      |");
		System.out.println("------------------------------");
		opcion = sc.nextInt();
		
		return opcion;
	}

	@Override
	public int mostrarFuncionalidades() {
		
		int opcion;
		System.out.println("------------------------------");
		System.out.println("|0. Volver                    |");
		System.out.println("|1. Mostrar consultas         |");
		System.out.println("|2. Imprimir consultas        |");
		System.out.println("------------------------------");
		opcion = sc.nextInt();
		
		return opcion;
	}

	@Override
	public int seleccionarConsultas() {
		int opcion;
		System.out.println("------------------------------");
		System.out.println("|0. Volver                    |");
		System.out.println("|1. Psicologia                |");
		System.out.println("|2. Traumatologia             |"); 
		System.out.println("|3. Fisioterapia              |");
		System.out.println("------------------------------");
		opcion = sc.nextInt();
		
		return opcion;
	}

}
