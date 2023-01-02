package clases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Jugador {
private String nombreCompleto;
private String numero;
private Date fechaNacimiento;
private Double sueldo;


public Jugador() {
	
}


public Jugador(String nombreCompleto, String numero, Date fechaNacimiento, Double sueldo) {
	super();
	this.nombreCompleto = nombreCompleto;
	this.numero = numero;
	this.fechaNacimiento = fechaNacimiento;
	this.sueldo = sueldo;
}


public String getNombreCompleto() {
	return nombreCompleto;
}


public void setNombreCompleto(String nombreCompleto) {
	this.nombreCompleto = nombreCompleto;
}


public String getNumero() {
	return numero;
}


public void setNumero(String numero) {
	this.numero = numero;
}


public Date getFechaNacimiento() {
	return fechaNacimiento;
}


public void setFechaNacimiento(Date fechaNacimiento) {
	this.fechaNacimiento = fechaNacimiento;
}


public Double getSueldo() {
	return sueldo;
}


public void setSueldo(Double sueldo) {
	this.sueldo = sueldo;
}



public String formatoFichero() {
	return this.nombreCompleto + ":"+ this.numero + ":" + formatoFechaString(this.fechaNacimiento)+ ":"
			+  this.sueldo ;
}
public static Date formatoFechaDate(String fechaString) throws ParseException {
	Date fecha_factura;
	SimpleDateFormat formatoLecturaFecha = new SimpleDateFormat("dd-MM-yyyy");
	fecha_factura = formatoLecturaFecha.parse(fechaString);
	return fecha_factura;
}

public static String formatoFechaString(Date fecha) {
	String fechaString;
	SimpleDateFormat fecha_impresion = new SimpleDateFormat("dd-MM-yyyy");
	fechaString = fecha_impresion.format(fecha);
	return fechaString;
}
public void mostrarEnPantalla() {
	System.out.println(
			this.nombreCompleto+ "\t" + 	
			this.numero + "\t" + 
			formatoFechaString(this.fechaNacimiento) + "\t" +
			this.sueldo+ "€"+ "\t");
}
}









