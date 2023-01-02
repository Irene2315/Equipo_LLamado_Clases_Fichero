package clases;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Equipo {

	private String nombre;
	private String estadio;
	private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();

	public Equipo() {

	}

	public Equipo(String nombre, String estadio, ArrayList<Jugador> jugadores) {
		super();
		this.nombre = nombre;
		this.estadio = estadio;
		this.jugadores = jugadores;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstadio() {
		return estadio;
	}

	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}

	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public void addJugador(Jugador jugador) {
		jugadores.add(jugador);
	}

	public double gastosEnSueldo() {
		double total;
		total = 0;
		for (int i = 0; i < jugadores.size(); i++) {
			total = jugadores.get(i).getSueldo()+total;
		}
		return total;
	}

	public void guardarEnFichero() throws FileNotFoundException {
	
		
		
		PrintWriter writer = new PrintWriter("recursos/" + nombreFichero());
		
		writer.println(this.nombre + ":" + this.estadio);
		writer.println();
		
		
		for (int i = 0; i < jugadores.size(); i++) {
			writer.println(jugadores.get(i).formatoFichero());
		}
		System.out.println("Los nuevos cambios han sido guardados con exito!!");
		
		writer.close();
	}

	public String nombreFichero() {

		String nombreDelFichero = getNombre().replace(" ", "_").toLowerCase()+ ".txt";

		return nombreDelFichero;

	}

	public void mostrarEnPantalla() {
		System.out.println("Nombre equipo: " + this.nombre + "\t\t" + this.estadio);

		System.out.println("nomCompt \tnum \tfechNac \tsueldo ");
		System.out.println("--------\t----\t------\t-----");
		for (Jugador jugador : jugadores) {
			jugador.mostrarEnPantalla();
		}
		System.out.println("\t\t\t\t---Total: " + this.gastosEnSueldo()+"€");
	}

}
