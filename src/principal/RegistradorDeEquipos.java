package principal;

import java.io.FileNotFoundException;

import java.text.ParseException;
import java.util.Scanner;

import clases.Equipo;
import clases.GestorEquipos;
import clases.Jugador;

/*
 * El método run cuando se ejecute siga el siguiente flujo: 
1. Pedir los datos del equipo
2. Pedir si se quiere introducir un jugador o archivar el equipo. (J o A)
a. Si se elige introducir un nuevo jugador (J):
i. Pedir los datos del jugador y añadir al equipo.
b. Si se elige archivar (A) en la pantalla se mostrarán los datos del equipo con sus gastos
en sueldos y sus jugadores. Se mostrará la opción de Salir(S) o Guardar (G).
i. Si se elige Salir se finalizará el programa.
ii. Si se elige Guardar se guardará la información en un fichero txt que se llame
con el mismo nombre que el equipo pero con barras bajas. Ej.: Si el equipo el
Real Sociedad el fichero se llamará real_sociedad.txt
 */
public class RegistradorDeEquipos {

	private static Scanner Scanner;

	public static void main(String[] args) throws ParseException, FileNotFoundException {

		GestorEquipos gf = new GestorEquipos();
		gf.run();
		Scanner = new Scanner(System.in);
		Equipo equipo = new Equipo();
		
		introducirEquipo(equipo);

		String opcion1;
		String opcion2;
		opcion2 = "";
		do {
			System.out.println("Que quiere introducir un jugador o archivar el equipo. (J o A)?");
			opcion1 = Scanner.nextLine();

			if (opcion1.toUpperCase().equals("J")) {

				introducirJugador(equipo);
				Scanner.nextLine();
			} else if (opcion1.toUpperCase().equals("A")) {
				equipo.mostrarEnPantalla();
				do {
				System.out.println("Que quiere Salir o Guardar (S o G)?");
				opcion2 = Scanner.nextLine();

				if (opcion2.toUpperCase().equals("G")) {
					equipo.guardarEnFichero();
				    
				}
				} while(!opcion2.toUpperCase().equals("S"));

			}

		} while (!opcion2.toUpperCase().equals("S"));

		Scanner.close();
	}

	public static void introducirEquipo(Equipo equipo) {

		String nombreEquipo;
		String estadioEquipo;
		System.out.println("-----Introduce los datos del equipo-------");
		System.out.println("Nombre_Equipo");
		nombreEquipo = Scanner.nextLine();
		System.out.println("Estadio");
		estadioEquipo = Scanner.nextLine();

		equipo.setNombre(nombreEquipo);
		equipo.setEstadio(estadioEquipo);
	}

	public static void introducirJugador(Equipo equipo) throws ParseException {
		Jugador jugador = new Jugador();
		String nombreCompletoJugador;
		String numeroJugador;
		String fechaNacimientoJugador;
		Double sueldoJugador;
		System.out.println("----Introduce los datos del usuario-----");
		System.out.println("Nombre Completo");
		nombreCompletoJugador = Scanner.nextLine();
		System.out.println("Numero");
		numeroJugador = Scanner.nextLine();
		System.out.println("Fecha nacimiento en este formato dd-MM-yyyy");
		fechaNacimientoJugador = Scanner.nextLine();
		System.out.println("Sueldo");
		sueldoJugador = Scanner.nextDouble();

		jugador.setNombreCompleto(nombreCompletoJugador);
		jugador.setNumero(numeroJugador);
		jugador.setFechaNacimiento(Jugador.formatoFechaDate(fechaNacimientoJugador));
		jugador.setSueldo(sueldoJugador);

		equipo.addJugador(jugador);

	}

}
